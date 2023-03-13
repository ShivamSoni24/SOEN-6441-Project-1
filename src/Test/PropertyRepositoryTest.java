package Test;

import Main.models.property.Apartment;
import Main.models.property.Property;
import Main.repository.Filter;
import org.junit.Test;

import static Test.TestSuite.propertyRepo;
import static org.junit.jupiter.api.Assertions.*;

public class PropertyRepositoryTest {

    @Test
    public void isPropertyExists() {
        assertTrue(propertyRepo.isPropertyExists("1"));
    }

    @Test
    public void addProperty() {
        assertNotNull(propertyRepo.addProperty(new Apartment("5000 Japon", "Dorval", "H49 B64", "QC", "CA", 786, 1, 2, 7845)));
    }

    @Test
    public void deleteProperty() {
        assertTrue(propertyRepo.deleteProperty("7"));
    }

    @Test
    public void getAll() {
        assertTrue(propertyRepo.getAll(Filter.ALL).size() > 0);
    }
}