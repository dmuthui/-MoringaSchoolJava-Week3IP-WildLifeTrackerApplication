package ke.co.safaricom.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangersTest {
    @DisplayName("Test to check if rangers_id passes the test")
    @Test
    void getRangers_id() {
        Rangers myRanger = new Rangers(1, "Leeshan","EK1443",721559122,"Tall and Strong","2", false);
        Integer expected = 1;
        assertEquals(1, myRanger.getRangers_id());
    }
    @DisplayName("Test to check if rangers_name passes the test")
    @Test
    void getRangers_name() {
        Rangers myRanger = new Rangers(1, "Leeshan","EK1443",721559122,"Tall and Strong","2", false);
        String expected = "Leeshan";
        assertEquals("Leeshan", myRanger.getRangers_name());
    }
    @DisplayName("Test to check if badge_number passes the test")
    @Test
    void getBadge_number() {
        Rangers myRanger = new Rangers(1, "Leeshan","EK1443",721559122,"Tall and Strong","2", false);
        String expected = "EK1443";
        assertEquals("EK1443", myRanger.getBadge_number());
    }
    @DisplayName("Test to check if rangers_contact passes the test")
    @Test
    void getRangers_contact() {
        Rangers myRanger = new Rangers(1, "Leeshan","EK1443",721559122,"Tall and Strong","2", false);
        Integer expected = 721559122;
        assertEquals(721559122, myRanger.getRangers_contact());
    }
    @DisplayName("Test to check if rangers_description passes the test")
    @Test
    void getRangers_description() {
        Rangers myRanger = new Rangers(1, "Leeshan","EK1443",721559122,"Tall and Strong", "2", false);
        String expected = "Tall and Strong";
        assertEquals("Tall and Strong", myRanger.getRangers_description());
    }
    @DisplayName("Test to check if rangers_sightings passes the test")
    @Test
    void getRangers_sightings() {
        Rangers myRanger = new Rangers(1, "Leeshan","EK1443",721559122,"Tall and Strong", "2", false);
        String expected = "2";
        assertEquals("2", myRanger.getRangers_sightings());
    }
    @DisplayName("Test to check if deleted when false passes the test")
    @Test
    void getDeleted() {
        Rangers myRanger = new Rangers(1, "Leeshan","EK1443",721559122,"Tall and Strong", "2", false);
        Boolean expected = false;
        assertEquals(false, myRanger.getDeleted());
    }
}