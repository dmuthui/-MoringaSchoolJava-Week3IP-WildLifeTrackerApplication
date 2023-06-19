package ke.co.safaricom.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SightingsTest {
    @DisplayName("Test to check whether the sighting_id passes the test")
    @Test
    void getSighting_id() {
        Sightings mySighting = new Sightings(1, "Endangered", "White Rhino", "Zone C", "Emerald", false);
        Integer expected = 1;
        assertEquals(1, mySighting.getSighting_id());
    }
    @DisplayName("Test to check whether the animal category passes the test")
    @Test
    void getAnimal_category() {
        Sightings mySighting = new Sightings(1, "Endangered", "White Rhino", "Zone C", "Emerald", false);
        String expected = "Endangered";
        assertEquals("Endangered", mySighting.getAnimal_category());
    }
    @DisplayName("Test to check whether the animal name passes the test")
    @Test
    void getAnimal_name() {
        Sightings mySighting = new Sightings(1, "Endangered", "White Rhino", "Zone C", "Emerald", false);
        String expected = "White Rhino";
        assertEquals("White Rhino", mySighting.getAnimal_name());
    }
    @DisplayName("Test to check whether the location passes the test")
    @Test
    void getLocation() {
        Sightings mySighting = new Sightings(1, "Endangered", "White Rhino", "Zone C", "Emerald", false);
        String expected = "Zone C";
        assertEquals("Zone C", mySighting.getLocation());
    }
    @DisplayName("Test to check whether the rangers name passes the test")
    @Test
    void getRangers_name() {
        Sightings mySighting = new Sightings(1, "Endangered", "White Rhino", "Zone C", "Emerald", false);
        String expected = "Emerald";
        assertEquals("Emerald", mySighting.getRangers_name());
    }
    @DisplayName("Test to check whether when deleted is false passes the test")
    @Test
    void getDeleted() {
        Sightings mySighting = new Sightings(1, "Endangered", "White Rhino", "Zone C", "Emerald", false);
        Boolean expected = false;
        assertEquals(false, mySighting.getDeleted());
    }
}