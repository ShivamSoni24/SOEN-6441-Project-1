package Test;

import Main.models.property.Property;
import Main.repository.Filter;
import org.junit.Test;

import static Test.TestSuite.propertyController;
import static org.junit.jupiter.api.Assertions.*;

public class PropertyControllerTest {

    @Test
    public void getAllProperties() {
        assertFalse(propertyController.getAllProperties(Filter.ALL) instanceof Property);
    }
}