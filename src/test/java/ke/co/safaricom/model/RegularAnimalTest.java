package ke.co.safaricom.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularAnimalTest {
    @DisplayName("Test to check if animal_id passes the test")
    @Test
    void getRegular_animal_id() {
        RegularAnimal myRegularAnimal = new RegularAnimal(1, "Cheetah", "Okay", "Adult",false);
        Integer expected = 1;
        assertEquals(1, myRegularAnimal.getRegular_animal_id());
    }
    @DisplayName("Test to check if animal_name passes the test")
    @Test
    void getAnimalName() {
        RegularAnimal myRegularAnimal = new RegularAnimal(1, "Cheetah", "Okay", "Adult",false);
        String expected = "Cheetah";
        assertEquals("Cheetah", myRegularAnimal.getAnimalName());
    }
    @DisplayName("Test to check if animal health passes the test")
    @Test
    void getHealth() {
        RegularAnimal myRegularAnimal = new RegularAnimal(1, "Cheetah", "Okay", "Adult",false);
        String expected = "Okay";
        assertEquals("Okay", myRegularAnimal.getHealth());
    }
    @DisplayName("Test to check if animal age passes the test")
    @Test
    void getAge() {
        RegularAnimal myRegularAnimal = new RegularAnimal(1, "Cheetah", "Okay", "Adult",false);
        String expected = "Adult";
        assertEquals("Adult", myRegularAnimal.getAge());
    }
    @DisplayName("Test to check if when deleted is false passes the test")
    @Test
    void getDeleted() {
        RegularAnimal myRegularAnimal = new RegularAnimal(1, "Cheetah", "Okay", "Adult",false);
        Boolean expected = false;
        assertEquals(false, myRegularAnimal.getDeleted());
    }
}