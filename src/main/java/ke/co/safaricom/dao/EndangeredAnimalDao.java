package ke.co.safaricom.dao;

import ke.co.safaricom.config.Database;
import ke.co.safaricom.model.EndangeredAnimal;
import ke.co.safaricom.model.RegularAnimal;
import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimalDao {
    //ADDS AN ENDANGERED ANIMAL INTO THE DATABASE
    public static void addEndangeredAnimal(EndangeredAnimal additionalEndangeredAnimal) {
        try (Connection db = Database.getConnect().open()) {
            // Database action
            String endangeredAnimalAdd = "INSERT INTO endangered_animal(endangeredAnimalName, health, age, deleted) VALUES (UPPER(:endangeredAnimalName), :health, :age, false)";
            db.createQuery(endangeredAnimalAdd)
                    .addParameter("endangeredAnimalName", additionalEndangeredAnimal.getEndangeredAnimalName())
                    .addParameter("health", additionalEndangeredAnimal.getHealth())
                    .addParameter("age", additionalEndangeredAnimal.getAge())
                    .executeUpdate();
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
//    public static void deleteRegularAnimal(String animalName){
//        try(Connection db = Database.getConnect().open()){
//            String deletedRegularAnimal = "UPDATE regular_animal SET deleted = (true) WHERE animalName = (:animalName);";
//            db.createQuery(deletedRegularAnimal).addParameter("animalName", animalName).executeUpdate();
//        } catch (Exception error) {
//            System.out.println(error.getMessage());
//        }
//    }
}
