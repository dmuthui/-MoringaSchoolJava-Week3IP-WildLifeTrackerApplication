package ke.co.safaricom.dao;

import ke.co.safaricom.config.Database;
import ke.co.safaricom.model.EndangeredAnimal;
import ke.co.safaricom.model.RegularAnimal;
import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimalDao {
    //THIS CODE CREATES THE ENDANGERED ANIMAL TABLE AUTOMATICALLY ON THE DATABASE ON STARTING THE APP
    public static void getStarted (){

        try(Connection db = Database.getConnect().open()){
            String createTable = "CREATE TABLE IF NOT EXISTS endangered_animal (endangered_animal_id SERIAL PRIMARY KEY, endangeredAnimalName varchar, health varchar, age varchar, deleted boolean default false)";
            db.createQuery(createTable).executeUpdate();
        } catch (Exception error) {System.out.println(error.getMessage());}
    }

    //ADDS AN ENDANGERED ANIMAL INTO THE DATABASE
    public static void addEndangeredAnimal(EndangeredAnimal additionalEndangeredAnimal) {
        try (Connection db = Database.getConnect().open()) {
            // Database action
            String endangeredAnimalAdd = "INSERT INTO endangered_animal(endangeredAnimalName, health, age, deleted) VALUES (UPPER(:endangeredAnimalName), :health, :age, false)";
            db.createQuery(endangeredAnimalAdd).bind(additionalEndangeredAnimal).executeUpdate();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    //RETRIEVES A LIST OF ALL THE ENDANGERED ANIMALS FROM THE DATABASE
    public static List<EndangeredAnimal> getAllEndangeredAnimals() {
        List<EndangeredAnimal> allEndangeredAnimals = null;
        try (Connection db = Database.getConnect().open()) {
            String EndangeredAnimals = "SELECT * FROM endangered_animal WHERE not deleted";
            allEndangeredAnimals = db.createQuery(EndangeredAnimals).executeAndFetch(EndangeredAnimal.class);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return allEndangeredAnimals;
        }
        return allEndangeredAnimals;
    }
//    //DELETES A ENDAGERED ANIMAL FROM THE DATABASE
    public static void deleteEndangeredAnimal(String endangeredAnimalName){
        try(Connection db = Database.getConnect().open()){
            String deletedEndangeredAnimal = "UPDATE endangered_animal SET deleted = (true) WHERE endangeredAnimalName = (:endangeredAnimalName);";
            db.createQuery(deletedEndangeredAnimal).addParameter("endangeredAnimalName", endangeredAnimalName).executeUpdate();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}
