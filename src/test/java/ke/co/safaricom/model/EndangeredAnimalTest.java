package ke.co.safaricom.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EndangeredAnimalTest {
   @DisplayName("Test for the Endangered_animal_id if it passes the test")
    @Test
    void getEndangered_animal_id() {
       EndangeredAnimal myEndangeredAnimal = new EndangeredAnimal(1, "Lion", "Healthy", "Adult", false);
       Integer expected = 1;
       assertEquals(1, myEndangeredAnimal.getEndangered_animal_id());
    }
    @DisplayName("Test for the EndangeredAnimalName if it passes the test")
    @Test
    void getEndangeredAnimalName() {
        EndangeredAnimal myEndangeredAnimal = new EndangeredAnimal(1, "Lion", "Healthy", "Adult", false);
        String expected = "Lion";
        assertEquals("Lion", myEndangeredAnimal.getEndangeredAnimalName());
    }
    @DisplayName("Test for the Endangered animal Health if it passes the test")
    @Test
    void getHealth() {
        EndangeredAnimal myEndangeredAnimal = new EndangeredAnimal(1, "Lion", "Healthy", "Adult", false);
        String expected = "Healthy";
        assertEquals("Healthy", myEndangeredAnimal.getHealth());
    }
    @DisplayName("Test for the Endangered animal age if it passes the test")
    @Test
    void getAge() {
        EndangeredAnimal myEndangeredAnimal = new EndangeredAnimal(1, "Lion", "Healthy", "Adult", false);
        String expected = "Adult";
        assertEquals("Adult", myEndangeredAnimal.getAge());
    }
    @DisplayName("Test for the Endangered animal deleted if false passes the test")
    @Test
    void getDeleted() {
        EndangeredAnimal myEndangeredAnimal = new EndangeredAnimal(1, "Lion", "Healthy", "Adult", false);
        Boolean expected = false;
        assertEquals(false, myEndangeredAnimal.getDeleted());
    }
}