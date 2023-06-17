package ke.co.safaricom.dao;

import ke.co.safaricom.config.Database;
import ke.co.safaricom.model.EndangeredAnimal;
import ke.co.safaricom.model.RegularAnimal;
import ke.co.safaricom.model.Sightings;
import org.sql2o.Connection;

import java.sql.SQLOutput;
import java.util.List;

public class SightingsDao {
    //ADDS A SIGHTING INTO THE DATABASE
    public static void addSighting(Sightings additionalSighting) {
        try (Connection db = Database.getConnect().open()) {
            // Database action
            String sightingAdd = "INSERT INTO sightings (regularAnimal, endangeredAnimal, animalName, location, rangersName, deleted) VALUES (UPPER(:regularAnimal), UPPER(:endangeredAnimal), UPPER(:animalName), UPPER(:location), UPPER(:rangersName), false)";
            db.createQuery(sightingAdd)
                    .addParameter("regularAnimal", additionalSighting.getRegularAnimal())
                    .addParameter("endangeredAnimal", additionalSighting.getEndangeredAnimal())
                    .addParameter("animalName", additionalSighting.getAnimalName())
                    .addParameter("location", additionalSighting.getLocation())
                    .addParameter("rangersName", additionalSighting.getRangersName())
                    .executeUpdate();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
        //RETRIEVES A LIST OF ALL THE SIGHTINGS FROM THE DATABASE
        public static List<Sightings> getAllSightings() {
            List<Sightings> allSightings = null;
            try (Connection db = Database.getConnect().open()) {
                String Sightings = "SELECT * FROM sightings WHERE not deleted;";
                allSightings = db.createQuery(Sightings).executeAndFetch(Sightings.class);
                System.out.println();
            } catch (Exception error) {
                System.out.println(error.getMessage());
                return allSightings;
            }
            return allSightings;
        }
    }


