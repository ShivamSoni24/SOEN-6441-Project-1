package Test;

import Main.models.property.Condo;
import Main.repository.Filter;
import org.junit.Test;

import static Test.TestSuite.propertySvc;
import static org.junit.jupiter.api.Assertions.*;

public class PropertyServiceTest {

    @Test
    public void getHouses() {
        assertNotNull(propertySvc.getHouses(Filter.ALL));
    }

    @Test
    public void getApartments() {
        assertTrue(propertySvc.getApartments(Filter.ALL).size() > 0);
    }

    @Test
    public void getCondos() throws Exception{
        assertTrue(propertySvc.getCondos(Filter.ALL).get(0) instanceof Condo);
    }
}