package ke.co.safaricom.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationsTest {
    @DisplayName("Test to check if location_id passes the test")
    @Test
    void getLocations_id() {
        Locations myLocation = new Locations(1, "Zone A", "Near the swap","North West","2", false);
        Integer expected = 1;
        assertEquals(1, myLocation.getLocations_id());
    }
    @DisplayName("Test to check if zone name passes the test")
    @Test
    void getZones_name() {
        Locations myLocation = new Locations(1, "Zone A", "Near the swap","North West","2", false);
        String expected = "Zone A";
        assertEquals("Zone A", myLocation.getZones_name());
    }
    @DisplayName("Test to check if zone description passes the test")
    @Test
    void getZones_descriptions() {
        Locations myLocation = new Locations(1, "Zone A", "Near the swap","North West","2", false);
        String expected = "Near the swap";
        assertEquals("Near the swap", myLocation.getZones_descriptions());
    }
    @DisplayName("Test to check if zone quadrant passes the test")
    @Test
    void getZones_quadrant() {
        Locations myLocation = new Locations(1, "Zone A", "Near the swap","North West","2", false);
        String expected = "North West";
        assertEquals("North West", myLocation.getZones_quadrant());
    }
    @DisplayName("Test to check if location sightings passes the test")
    @Test
    void getLocation_sightings() {
        Locations myLocation = new Locations(1, "Zone A", "Near the swap","North West","2", false);
        String expected = "2";
        assertEquals("2", myLocation.getLocation_sightings());
    }
    @DisplayName("Test to check if deleted is false passes the test")
    @Test
    void getDeleted() {
        Locations myLocation = new Locations(1, "Zone A", "Near the swap","North West","2", false);
        Boolean expected = false;
        assertEquals(false, myLocation.getDeleted());
    }
}