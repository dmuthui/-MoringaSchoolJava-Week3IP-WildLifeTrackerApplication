package ke.co.safaricom.dao;

import ke.co.safaricom.config.Database;
import ke.co.safaricom.model.Rangers;
import ke.co.safaricom.model.RegularAnimal;
import org.sql2o.Connection;

import java.util.List;

public class RangersDao {

    //ADDS A RANGER INTO THE DATABASE
    public static void addRanger(Rangers additionalRanger) {
        try (Connection db = Database.getConnect().open()) {
            // Database action
            String rangerAdd = "INSERT INTO rangers(rangers_name, badge_number, rangers_contact, rangers_description, rangers_sightings,deleted) VALUES (UPPER(:rangers_name), :badge_number, :rangers_contact,UPPER(:rangers_description),UPPER(:rangers_sightings), false)";
            db.createQuery(rangerAdd)
                    .addParameter("rangers_name", additionalRanger.getRangers_name())
                    .addParameter("badge_number", additionalRanger.getBadge_number())
                    .addParameter("rangers_contact", additionalRanger.getRangers_contact())
                    .addParameter("rangers_description", additionalRanger.getRangers_description())
                    .addParameter("rangers_sightings", additionalRanger.getRangers_sightings())
                    .executeUpdate();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    //RETRIEVES A LIST OF ALL THE RANGERS FROM THE DATABASE
    public static List<Rangers> getAllRangers() {
        List<Rangers> allRangers = null;
        try (Connection db = Database.getConnect().open()) {
            String Rangers = "SELECT * FROM rangers WHERE not deleted";
            allRangers = db.createQuery(Rangers).executeAndFetch(Rangers.class);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return allRangers;
        }
        return allRangers;
    }

    //DELETES A RANGER FROM THE DATABASE
    public static void deleteRangers(String rangers_name){
        try(Connection db = Database.getConnect().open()){
            String deletedRangers = "UPDATE rangers SET deleted = (true) WHERE rangers_name = (:rangers_name);";
            db.createQuery(deletedRangers).addParameter("rangers_name", rangers_name).executeUpdate();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}
