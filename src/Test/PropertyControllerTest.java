package Test;

import Main.models.property.Apartment;
import Main.models.property.Condo;
import Main.models.property.House;
import Main.models.property.Property;
import Main.repository.Filter;
import org.junit.Test;

import static Test.TestSuite.propertyController;
import static org.junit.jupiter.api.Assertions.*;

public class PropertyControllerTest {

    @Test
    public void getAllApartment() {
        assertTrue(propertyController.getAllApartments(Filter.ALL).get(0) instanceof Apartment);
    }@Test
    public void getAllCondos() {
        assertTrue(propertyController.getAllCondos(Filter.ALL).get(0) instanceof Condo);
    }@Test
    public void getAllHouse() {
        assertTrue(propertyController.getAllHouses(Filter.ALL).get(0) instanceof House);
    }

    public void getAllProperties() {
        assertFalse(propertyController.getAllProperties(Filter.ALL).get(0) instanceof Property);
    }
}