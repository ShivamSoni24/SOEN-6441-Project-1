package Test;

import Main.models.Contract;
import org.junit.Test;

import java.time.LocalDate;

import static Test.TestSuite.contractRepo;
import static Test.TestSuite.userSvc;
import static org.junit.jupiter.api.Assertions.*;

public class ContractRepositoryTest {

    @Test
    public void addContract() {
        assertEquals("7", contractRepo.addContract(new Contract("5", "5", LocalDate.of(2023, 6, 6), 8562)));
    }

    @Test
    public void updateContract() {
        assertFalse(contractRepo.updateContract(new Contract("7", "7", LocalDate.of(2023, 8, 6), 8560)));
    }

    @Test
    public void isContractExists() {
        assertTrue(contractRepo.isContractExists("7"));
    }

    @Test
    public void deleteContract() {
        assertTrue(contractRepo.deleteContract("7"));
    }

    @Test
    public void getContracts() {
        assertNotNull(contractRepo.getContracts());
    }
}