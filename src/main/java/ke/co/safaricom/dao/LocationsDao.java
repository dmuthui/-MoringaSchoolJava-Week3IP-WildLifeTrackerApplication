package ke.co.safaricom.dao;

import ke.co.safaricom.config.Database;
import ke.co.safaricom.model.Locations;
import ke.co.safaricom.model.RegularAnimal;
import org.sql2o.Connection;

import java.util.List;

public class LocationsDao {
    //THIS CODE CREATES THE LOCATIONS TABLE AUTOMATICALLY ON THE DATABASE ON STARTING THE APP
    public static void getStarted (){

        try(Connection db = Database.getConnect().open()){
            String createTable = "CREATE TABLE IF NOT EXISTS locations(locations_id SERIAL PRIMARY KEY, zones_name varchar, zones_descriptions varchar, zones_quadrant varchar, location_sightings varchar,deleted BOOLEAN DEFAULT false);";
            db.createQuery(createTable).executeUpdate();
        } catch (Exception error) {System.out.println(error.getMessage());}
    }

    //ADDS A LOCATION INTO THE DATABASE
    public static void addLocation(Locations additionalLocation) {
        try (Connection db = Database.getConnect().open()) {
            // Database action
            String locationAdd = "INSERT INTO locations(zones_name, zones_descriptions, zones_quadrant, location_sightings, deleted) VALUES (UPPER(:zones_name), UPPER(:zones_descriptions), UPPER(:zones_quadrant), UPPER(:location_sightings), false)";
            db.createQuery(locationAdd).bind(additionalLocation).executeUpdate();
        } catch (Exception error) {
            System.out.println(error.getMessage());

        }
    }

    //RETRIEVES A LIST OF ALL THE LOCATIONS FROM THE DATABASE
    public static List<Locations> getAllLocations() {
        List<Locations> allLocations = null;
        try (Connection db = Database.getConnect().open()) {
            String Locations = "SELECT * FROM locations WHERE not deleted";
            allLocations = db.createQuery(Locations).executeAndFetch(Locations.class);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return allLocations;
        }
        return allLocations;
    }

    //RETRIEVES A LIST OF EACH ZONE WITH THE DETAILS FROM THE DATABASE
    public static Locations getLocationByZoneName(String zones_name) {
        Locations location = null;
        try (Connection db = Database.getConnect().open()) {
            String query = "SELECT * FROM locations WHERE zones_name =:zones_name AND NOT deleted";
            location = db.createQuery(query)
                    .addParameter("zones_name", zones_name )
                    .executeAndFetchFirst(Locations.class);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return location;
        }
        return location;
    }

    //DELETES A LOCATION FROM THE DATABASE
    public static void deleteLocations(String zones_name) {
        try (Connection db = Database.getConnect().open()) {
            String deletedLocations = "UPDATE locations SET deleted = (true) WHERE zones_name = (:zones_name);";
            db.createQuery(deletedLocations).addParameter("zones_name", zones_name).executeUpdate();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}

