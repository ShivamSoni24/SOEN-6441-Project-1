package Test;

import Main.models.Contract;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import Test.TestSuite.*;

import java.time.LocalDate;

import static Test.TestSuite.contractController;
import static Test.TestSuite.userController;
import static org.junit.jupiter.api.Assertions.*;

public class ContractControllerTest {

    @Test
    public void getRentStatus() throws Exception {
        assertTrue(contractController.getRentStatus("1", "1", 2, 2023));
    }

    @Test
    public void terminateContract() throws Exception {
        contractController.rentUnit("4", "4", LocalDate.of(2023, 3, 28), 9942);
        assertTrue(contractController.terminateContract("4", "4"));
    }

    @Test
    public void rentUnit() throws Exception{
        assertEquals("4", contractController.rentUnit("5", "5", LocalDate.of(2023, 9,24), 5846));
        contractController.terminateContract("5", "5");
    }

    @Test
    public void getLeases() throws Exception {
        assertTrue(contractController.getLeases().get(0) instanceof Contract);
    }
}