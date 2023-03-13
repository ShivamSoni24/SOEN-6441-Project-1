package Test;

import Main.models.Contract;
import org.junit.Test;
import java.time.LocalDate;
import static Test.TestSuite.contractSvc;
import static org.junit.jupiter.api.Assertions.*;

public class ContractServiceTest {

    @Test
    public void getContract() {
        assertTrue(contractSvc.getContractBy("1") instanceof Contract);
    }

    @Test
    public void createContract() throws Exception {
        assertEquals("6", contractSvc.createContract(new Contract("2", "2", LocalDate.of(2023, 8, 24), 1000)));
    }

    @Test
    public void deleteContract() throws Exception {
        assertTrue(contractSvc.deleteContract("3", "3"));
    }
}