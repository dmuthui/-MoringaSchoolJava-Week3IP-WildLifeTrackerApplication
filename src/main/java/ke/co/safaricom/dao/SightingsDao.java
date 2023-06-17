package ke.co.safaricom.dao;

import ke.co.safaricom.config.Database;
import ke.co.safaricom.model.RegularAnimal;
import ke.co.safaricom.model.Sightings;
import org.sql2o.Connection;

public class SightingsDao {
    //ADDS A SIGHTING INTO THE DATABASE
    public static void addSighting(Sightings additionalSighting) {
        try (Connection db = Database.getConnect().open()) {
            // Database action
            String sightingAdd = "INSERT INTO sightings(animalCategory varchar, animalName varchar, location varchar, rangersName varchar, timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP, deleted boolean default false); VALUES (UPPER(:animalCategory), (UPPER(:animalName), (UPPER(:location), (UPPER(:rangersName), CURRENT_TIMESTAMP, false)";
            db.createQuery(sightingAdd)
                    .addParameter("animalCategory", additionalSighting.getAnimalCategory())
                    .addParameter("animalName", additionalSighting.getAnimalName())
                    .addParameter("location", additionalSighting.getLocation())
                    .addParameter("rangersName", additionalSighting.getRangersName())
                    .addParameter("timestamp", additionalSighting.getTimestamp())
                    .executeUpdate();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

}
