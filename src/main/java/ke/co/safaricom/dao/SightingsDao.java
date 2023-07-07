package ke.co.safaricom.dao;

import ke.co.safaricom.config.Database;
import ke.co.safaricom.dto.SightingDto;
import ke.co.safaricom.model.*;
import org.sql2o.Connection;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class SightingsDao {
     //THIS CODE CREATES THE SIGHTINGS TABLE AUTOMATICALLY ON THE DATABASE ON STARTING THE APP
    public static void getStarted (){

        try(Connection db = Database.getConnect().open()){
            String createTable = "CREATE TABLE IF NOT EXISTS sightings (sighting_id SERIAL PRIMARY KEY,animal_category varchar, animal_name varchar, zones_name varchar, rangers_name varchar, sighting_time timestamptz, deleted BOOLEAN DEFAULT false);";
            db.createQuery(createTable).executeUpdate();
        } catch (Exception error) {System.out.println(error.getMessage());}
    }
    //ADDS A SIGHTING INTO THE DATABASE
     public static void addSighting(Sightings additionalSighting) {
         try (Connection db = Database.getConnect().open()) {
            // Database action
            String sightingAdd = "INSERT INTO sightings (animal_category, animal_name, zones_name, rangers_name, sighting_time, deleted) VALUES (UPPER(:animal_category), :animal_name, :zones_name, UPPER(:rangers_name), :sighting_time, false)";
            db.createQuery(sightingAdd).bind(additionalSighting).executeUpdate();
         } catch (Exception ex) {
            System.out.println("Error adding sighting: " + ex.getMessage());
         }
      }

 //RETRIEVES A LIST OF ALL THE SIGHTINGS FROM THE DATABASE
 public static List<SightingDto> getAllSightings() {
     ArrayList<SightingDto> output = new ArrayList<>();
     List<Sightings> allSightings = null;
     try (Connection db = Database.getConnect().open()) {
         String sightings = "SELECT * FROM sightings WHERE not deleted;";
         allSightings = db.createQuery(sightings)
                 .executeAndFetch(Sightings.class);
         for(Sightings sighting: allSightings){
             // todo: get location
             Locations zone = LocationsDao.getLocationByZoneName(sighting.getZones_name());
             // todo: get ranger
             Rangers ranger = RangersDao.getRangerByRangerName(sighting.getRangers_name());
             SightingDto dto = new SightingDto();
             dto.setLocation(zone);
             dto.setRanger(ranger);
             dto.setSighting(sighting);
             output.add(dto);
         }
     } catch (Exception error) {
         System.out.println(error.getMessage());
         return output;
     }
     return output;
 }

      //DELETES A SIGHTING FROM THE DATABASE
      public static void deleteSighting(String animal_name ){
        try(Connection db = Database.getConnect().open()){
            String deletedSighting = "UPDATE sightings SET deleted = (true) WHERE animal_name = (:animal_name);";
            db.createQuery(deletedSighting).addParameter("animal_name", animal_name).executeUpdate();
            } catch (Exception error) {
                    System.out.println(error.getMessage());
            }
        }
    }




