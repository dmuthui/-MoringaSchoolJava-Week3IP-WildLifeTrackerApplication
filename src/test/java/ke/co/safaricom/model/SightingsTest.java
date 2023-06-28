package ke.co.safaricom.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class SightingsTest {
    @DisplayName("Test to check the value of sighting_id")
    @Test
    void testSightingId() {
        Sightings mySighting = new Sightings(1, "Regular or Endangered", "White Rhino", "Zone C",
                "Emerald", new Date(), false);
        Integer expected = 1;
        assertEquals(1, mySighting.getSighting_id());
    }

    @DisplayName("Test to check the value of animal_category")
    @Test
    void getAnimal_category() {
        Sightings mySighting = new Sightings(1, "Regular or Endangered", "White Rhino", "Zone C", "Emerald", new Date(), false);
        String expected = "Regular or Endangered";
        assertEquals("Regular or Endangered", mySighting.getAnimal_category());
    }

    @DisplayName("Test to check the value of animal_name")
    @Test
    void getAnimal_name() {
        Sightings mySighting = new Sightings(1, "Regular or Endangered", "White Rhino", "Zone C", "Emerald", new Date(), false);
        String expected = "White Rhino";
        assertEquals("White Rhino", mySighting.getAnimal_name());
    }

    @DisplayName("Test to check the value of location")
    @Test
    void getLocation() {
        Sightings mySighting = new Sightings(1, "Regular or Endangered", "White Rhino", "Zone C", "Emerald", new Date(), false);
        String expected = "Zone C";
        assertEquals("Zone C", mySighting.getLocation());
    }

    @DisplayName("Test to check the value of Rangers_name")
    @Test
    void getRangers_name() {
        Sightings mySighting = new Sightings(1, "Regular or Endangered", "White Rhino", "Zone C", "Emerald", new Date(), false);
        String expected = "Emerald";
        assertEquals("Emerald", mySighting.getRangers_name());
    }

    @DisplayName("Test to check the value of Sighting_time")
    @Test
    void getSighting_time() {
        Date expectedDate = new Date();
        Sightings mySighting = new Sightings(1, "Endangered", "White Rhino", "Zone C", "Emerald", expectedDate, false);
        assertEquals(expectedDate, mySighting.getSighting_time());
    }

    @DisplayName("Test to check the value of Bolean if it's false")
    @Test
    void getDeleted() {
        Sightings mySighting = new Sightings(1, "Endangered", "White Rhino", "Zone C", "Emerald", new Date(), false);
        Boolean expected = false;
        assertEquals(false, mySighting.getDeleted());
    }
}