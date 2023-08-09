package ke.co.safaricom;

import com.google.gson.GsonBuilder;
import ke.co.safaricom.dao.*;
import ke.co.safaricom.dto.SightingDto;
import ke.co.safaricom.model.*;
import org.apache.hadoop.shaded.com.google.gson.Gson;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import spark.ModelAndView;
import spark.Session;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.io.OutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static spark.Spark.*;
import spark.Session;

public class App {
    public static void main(String[] args) {
        // To SERVE THE STATIC FILES LOCATION
        staticFileLocation("/public");

        //INITIALIZATION OF THE HANDLEBARS
        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

        //THE ROUTE TO VIEW HOME PAGE WHEN AN APPLICATION IS STARTED BY INITIALIZING THE TABLES
        get("/login", (request, response) -> {
            Map<String, Object> WildLifeTrackerList = new HashMap<>();
            EndangeredAnimalDao.getStarted();
            LocationsDao.getStarted();
            RangersDao.getStarted();
            RegularAnimalDao.getStarted();
            SightingsDao.getStarted();
            return new ModelAndView(new HashMap<>(), "login.hbs");
        }, engine);

        // Define a route for the login page
        get("/login", (request, response) -> {
            return new ModelAndView(new HashMap<>(), "login.hbs");
        }, engine);

        // Handle login form submission
        post("/login", (request, response) -> {
            String username = request.queryParams("username");
            String password = request.queryParams("password");

            // Perform authentication (Replace with your actual authentication logic)
            if (isValidUser(username, password)) {
                Session session = request.session();
                session.attribute("username", username);
                response.redirect("/");
            } else {
                // Invalid credentials, show error message or redirect back to login page
                response.redirect("/login");
            }

            return null;
        });

        // Define a route for the home page
        get("/", (request, response) -> {
            Session session = request.session();
            String username = session.attribute("username");

            // Check if the user is authenticated
            if (username != null) {
                // Render the dashboard page
                Map<String, Object> model = new HashMap<>();
                model.put("username", username);
                return new ModelAndView(model, "home.hbs");
            } else {
                // Redirect to login page if not authenticated
                response.redirect("/login");
                return null;
            }
        }, engine);

       // Define a route for logout
        get("/logout", (request, response) -> {
            Session session = request.session();
            session.removeAttribute("username");
            response.redirect("/login");
            return null;
        }, engine);


        //THE ROUTE TO SERVE ADD ANIMAL AFTER CLICKING ADD ANIMAL BUTTON
        get("/add-animal", (request, response) -> {
            return new ModelAndView(new HashMap<>(), "addAnimalForm.hbs");
        }, engine);

        //ROUTE TO SERVE POSTING OF ADD REGULAR ANIMAL TO THE DATABASE
        post("/add-animal", (request, response) -> {
            // Initializing the regular animal
            Integer regular_animal_id = null;
            String animalName = request.queryParams("animalName");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            Boolean deleted = false;
            RegularAnimal additionalRegularAnimal = new RegularAnimal(regular_animal_id, animalName, health, age, deleted);
            RegularAnimalDao.addRegularAnimal(additionalRegularAnimal);
            response.redirect("/regular-animal-list");
            return null;
        });
        //THE ROUTE TO HANDLE GETTING ALL REGULAR ANIMALS FROM DATABASE ON THE ANIMALS LIST
        get("/regular-animal-list", (req, res) -> {
            Map<String, List<RegularAnimal>> regularAnimalList = new HashMap<>();
            regularAnimalList.put("regularAnimals", RegularAnimalDao.getAllRegularAnimals());
            return new ModelAndView(regularAnimalList, "animalsList.hbs");
        }, engine);

        //DELETING A REGULAR ANIMAL FROM THE ANIMALS LIST PAGE
        get("/delete-regularAnimal/:animalName", (req, res) -> {
            String animalName = req.params(":animalName");
            RegularAnimalDao.deleteRegularAnimal(animalName);
            res.redirect("/regular-animal-list");
            return null;
        }, engine);

        //THE ROUTE TO SERVE ADD ENDANGERED ANIMAL AFTER CLICKING ADD ADD ENDANGERED ANIMAL BUTTON
        get("/add-endangered", (request, response) -> {
            return new ModelAndView(new HashMap<>(), "endangeredAnimalForm.hbs");
        }, engine);

        //ROUTE TO SERVE POSTING OF ADD ENDANGERED ANIMAL TO THE DATABASE
        post("/add-endangered-animal", (request, response) -> {
            // Initializing the endangered animal
            Integer endangered_animal_id = null;
            String endangeredAnimalName = request.queryParams("endangeredAnimalName");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            Boolean deleted = false;
            EndangeredAnimal additionalEndangeredAnimal = new EndangeredAnimal(endangered_animal_id, endangeredAnimalName, health, age, deleted);
            EndangeredAnimalDao.addEndangeredAnimal(additionalEndangeredAnimal);
            response.redirect("/animal-list");
            return null;
        });

        // THE ROUTE TO HANDLE GETTING ALL ENDANGERED ANIMALS FROM DATABASE ON THE ANIMALS LIST
        get("/animal-list", (req, res) -> {
            Map<String, List<EndangeredAnimal>> endangeredAnimalList = new HashMap<>();
            endangeredAnimalList.put("endangeredAnimals", EndangeredAnimalDao.getAllEndangeredAnimals());
            return new ModelAndView(endangeredAnimalList, "animalsList.hbs");
        }, engine);

        //DELETING AN ENDANGERED ANIMAL FROM THE ANIMALS LIST PAGE
        get("/delete-endangeredAnimalName/:endangeredAnimalName", (req, res) -> {
            String endangeredAnimalName = req.params(":endangeredAnimalName");
            EndangeredAnimalDao.deleteEndangeredAnimal(endangeredAnimalName);
            res.redirect("/animal-list");
            return null;
        }, engine);

        //THE ROUTE TO SERVE ADD SIGHTING AFTER CLICKING ADD REPORT/RECORD SIGHTINGS BUTTON
        get("/add-sighting", (req, res) -> {
            // Retrieve data for rendering the form
            Map<String, Object> LocationsList = new HashMap<>();
            LocationsList.put("location", LocationsDao.getAllLocations());
            LocationsList.put("ranger", RangersDao.getAllRangers());
            // Render the form template with the data
            return new ModelAndView(LocationsList, "sightingsForm.hbs");
        }, engine);


        //ROUTE TO SERVE POSTING OF REPORT/RECORD A SIGHTING TO THE DATABASE
        // Define route for sighting form submission
        post("/add-sighting", (request, response) -> {
            // Get form inputs
            Integer sighting_id = null;
            String animal_category = request.queryParams("animal_category");
            String animal_name = request.queryParams("animal_name");
            String zones_name = request.queryParams("zones_name");
            String rangers_name = request.queryParams("rangers_name");
            Date sighting_time = new Date();
            Boolean deleted = false;
            // Create a new sighting object
            Sightings additionalSighting = new Sightings(sighting_id, animal_category, animal_name, zones_name, rangers_name, sighting_time, deleted);
            // Add the sighting to the database
            SightingsDao.addSighting(additionalSighting);
            // Redirect to the sighting list page
            response.redirect("/sighting-list");
            return null;
        });

        // THE ROUTE TO HANDLE GETTING ALL SIGHTINGS FROM DATABASE ON THE SIGHTING LIST
        // Define route for sighting list page
        get("/sighting-list", (req, res) -> {
            // Get the list of sightings from the database
            List<SightingDto> sightingLists = SightingsDao.getAllSightings();

            // Render the sighting list template with the sightings data
            Map<String, Object> model = new HashMap<>();
            model.put("sightingList", sightingLists);
            return new ModelAndView(model, "sightingList.hbs");
        }, engine);

// Define route for downloading the sightings data in Excel format
        get("/download-sightings", (req, res) -> {
            // Get the list of sightings from the database
            List<SightingDto> sightingLists = SightingsDao.getAllSightings();

            // Create a new Excel workbook and sheet
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Sightings");

            // Create a header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Animal Category");
            headerRow.createCell(1).setCellValue("Animal Name");
            headerRow.createCell(2).setCellValue("Location");
            headerRow.createCell(3).setCellValue("Ranger Name");
            headerRow.createCell(4).setCellValue("Sighting Time");

            // Create the date-time format
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            // Populate the data rows
            int rowIndex = 1;
            for (SightingDto sighting : sightingLists) {
                Row dataRow = sheet.createRow(rowIndex++);
                dataRow.createCell(0).setCellValue(sighting.getSighting().getAnimal_category());
                dataRow.createCell(1).setCellValue(sighting.getSighting().getAnimal_name());

                // Combine zone name, zone description, and zone quadrant into a single string
                String zoneInfo = sighting.getLocation().getZones_name() + " - " +
                        sighting.getLocation().getZones_descriptions() + " - " +
                        sighting.getLocation().getZones_quadrant();
                dataRow.createCell(2).setCellValue(zoneInfo);

                // Combine ranger's name, badge number, and contact into a single string
                String rangerInfo = sighting.getRanger().getRangers_name() + " - " +
                        sighting.getRanger().getBadge_number() + " - " +
                        sighting.getRanger().getRangers_contact();
                dataRow.createCell(3).setCellValue(rangerInfo);

                dataRow.createCell(4).setCellValue(sighting.getSighting().getSighting_time());
            }

            // Set the response headers to indicate it's an Excel file
            res.header("Content-Disposition", "attachment; filename=SightingsReport.xlsx");
            res.type("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

            // Stream the Excel data to the client
            try (OutputStream outputStream = res.raw().getOutputStream()) {
                workbook.write(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Return null to end the response
            return null;
        });

        //ROUTE FOR INITIALING GSON THAT ALLOWS LINKING OF NAMES TO THE SIGHTINGS FORM
        Gson gson = new Gson();
        // Endpoint for fetching endangered animals
        get("/regular-animals", (req, res) -> {
            List<RegularAnimal> regularAnimals = RegularAnimalDao.getAllRegularAnimals();
            return gson.toJson(regularAnimals);
        });
        // Endpoint for fetching endangered animals
        get("/endangered-animals", (req, res) -> {
            List<EndangeredAnimal> endangeredAnimals = EndangeredAnimalDao.getAllEndangeredAnimals();
            return gson.toJson(endangeredAnimals);
        });

        //DELETING A SITTING FROM THE ANIMALS LIST PAGE
        get("/delete-animal_name/:animal_name", (req, res) -> {
            String animal_name = req.params(":animal_name");
            SightingsDao.deleteSighting(animal_name);
            res.redirect("/sighting-list");
            return null;
        }, engine);

        //THE ROUTE TO SERVE ADD RANGERS AFTER CLICKING ADD RANGER BUTTON
        get("/add-rangers", (request, response) -> {
            return new ModelAndView(new HashMap<>(), "rangersForm.hbs");
        }, engine);

        //ROUTE TO SERVE POSTING OF RANGERS  TO THE DATABASE
        // Define route for rangers form submission
        post("/add-ranger", (request, response) -> {
            // Get form inputs
            Integer rangers_id = null;
            String rangers_name = request.queryParams("rangers_name");
            String badge_number = request.queryParams("badge_number");
            Integer rangers_contact = Integer.parseInt(request.queryParams("rangers_contact"));
            String rangers_description = request.queryParams("rangers_description");
            String rangers_sightings = request.queryParams("rangers_sightings");
            Boolean deleted = false;
            // Create a new rangers object
            Rangers additionalRangers = new Rangers(rangers_id, rangers_name, badge_number, rangers_contact, rangers_description, rangers_sightings, deleted);
            // Add the rangers to the database
            RangersDao.addRanger(additionalRangers);
            // Redirect to the rangers list page
            response.redirect("/rangers-list");
            return null;
        });

        // THE ROUTE TO HANDLE GETTING ALL RANGERS FROM DATABASE ON THE RANGERS LIST
        // Define route for Rangers list page
        get("/rangers-list", (req, res) -> {
            // Get the list of rangers from the database
            Map<String, List<Rangers>> rangersList = new HashMap<>();
            // Render the rangers list template with the rangers data
            rangersList.put("ranger", RangersDao.getAllRangers());
            return new ModelAndView(rangersList, "rangersList.hbs");
        }, engine);

        //DELETING A RANGER FROM THE RANGERS LIST PAGE
        get("/delete-rangers_name/:rangers_name", (req, res) -> {
            String rangers_name = req.params(":rangers_name");
            RangersDao.deleteRangers(rangers_name);
            res.redirect("/rangers-list");
            return null;
        }, engine);

        //THE ROUTE TO SERVE ADD LOCATION AFTER CLICKING ADD LOCATION BUTTON
        get("/add-locations", (request, response) -> {
            return new ModelAndView(new HashMap<>(), "locationForm.hbs");
        }, engine);

        //ROUTE TO SERVE POSTING OF LOCATIONS  TO THE DATABASE
        // Define route for location form submission
        post("/add-zone", (request, response) -> {
            // Get form inputs
            Integer locations_id = null;
            String zones_name = request.queryParams("zones_name");
            String zones_descriptions = request.queryParams("zones_descriptions");
            String zones_quadrant = request.queryParams("zones_quadrant");
            String location_sightings = request.queryParams("location_sightings");
            Boolean deleted = false;
            // Create a new locations object
            Locations additionalLocations = new Locations(locations_id, zones_name, zones_descriptions, zones_quadrant, location_sightings, deleted);
            // Add the locations to the database
            LocationsDao.addLocation(additionalLocations);
            // Redirect to the locations list page
            response.redirect("/locations-list");
            return null;
        });

        // THE ROUTE TO HANDLE GETTING ALL LOCATIONS FROM DATABASE ON THE LOCATIONS LIST
        // Define route for Locations list page
        get("/locations-list", (req, res) -> {
            // Get the list of Locations from the database
            Map<String, List<Locations>> LocationsList = new HashMap<>();
            // Render the Locations list template with the Locations data
            LocationsList.put("location", LocationsDao.getAllLocations());
            return new ModelAndView(LocationsList, "locationList.hbs");
        }, engine);

        //DELETING A LOCATION FROM THE LOCATIONS LIST PAGE
        get("/delete-zones_name/:zones_name", (req, res) -> {
            String zones_name = req.params(":zones_name");
            LocationsDao.deleteLocations(zones_name);
            res.redirect("/locations-list");
            return null;
        }, engine);


        //THE ROUTE TO SERVE ABOUT APP PAGE AFTER CLICKING ON ABOUT APP PAGE ON HOME PAGE
        get("/about-app-page", (request, response) -> {
            return new ModelAndView(new HashMap<>(), "aboutAppPage.hbs");
        }, engine);

        //THE SEARCH PARAMETERS on every table have been implemented using jQuerry where you can also sort the table heads.
    }

    private static boolean isValidUser (String username, String password){
        // For this example, we'll use hardcoded username and password
        // Sample valid user
        String validUsername = "admin";
        String validPassword = "password";

        return username.equals(validUsername) && password.equals(validPassword);
    }

}

