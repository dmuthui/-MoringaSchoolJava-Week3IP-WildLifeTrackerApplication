package ke.co.safaricom;

import com.google.gson.GsonBuilder;
import ke.co.safaricom.dao.EndangeredAnimalDao;
import ke.co.safaricom.dao.RegularAnimalDao;
import ke.co.safaricom.dao.SightingsDao;
import ke.co.safaricom.model.EndangeredAnimal;
import ke.co.safaricom.model.RegularAnimal;
import ke.co.safaricom.model.Sightings;
import org.apache.hadoop.shaded.com.google.gson.Gson;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
// To SERVE THE STATIC FILES LOCATION
        staticFileLocation("/public");

//INITIALIZATION OF THE HANDLEBARS
        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

//THE ROUTE TO VIEW HOME PAGE
        get("/", (request, response) -> {
            return new ModelAndView(new HashMap<>(), "home.hbs");
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
        get("/add-sighting", (request, response) -> {
            return new ModelAndView(new HashMap<>(), "sightingsForm.hbs");
        }, engine);

//ROUTE TO SERVE POSTING OF REPORT/RECORD A SIGHTING TO THE DATABASE
        post("/add-sighting", (request, response) -> {
            // Initializing the sighting
            Integer sighting_id = null;
            String regularAnimal= request.queryParams("regularAnimal");
            String endangeredAnimal= request.queryParams("endangeredAnimal");
            String animalName= request.queryParams("animalName");
            String location = request.queryParams("location");
            String rangersName = request.queryParams("rangersName");
            Boolean deleted = false;
            Sightings additionalSighting = new Sightings(sighting_id, regularAnimal, endangeredAnimal, animalName, location, rangersName, deleted);
            SightingsDao.addSighting(additionalSighting );
            response.redirect("/sighting-list");
            return null;
        });

// THE ROUTE TO HANDLE GETTING ALL SIGHTINGS FROM DATABASE ON THE SIGHTING LIST
        get("/sighting-list", (req, res) -> {
            Map<String, List<Sightings>> sightingList = new HashMap<>();
            sightingList.put("sightings", SightingsDao.getAllSightings());
            return new ModelAndView(sightingList, "sightingList.hbs");
        }, engine);

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

//THE ROUTE TO SERVE ABOUT APP PAGE AFTER CLICKING ON ABOUT APP PAGE ON HOME PAGE
        get("/about-app-page", (request, response) -> {
            return new ModelAndView(new HashMap<>(), "aboutAppPage.hbs");
        }, engine);

    }
}