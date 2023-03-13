package Test;

import Main.models.user.Tenant;
import org.junit.Test;

import static Test.TestSuite.userRepo;
import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {

    @Test
    public void isExists() {
        assertTrue(userRepo.isExists("1"));
    }

    @Test
    public void add() {
        assertNotNull(userRepo.add(new Tenant("Mike Danger", "MD@gmail.com", "7856942310")));
    }

    @Test
    public void delete() {
        assertTrue(userRepo.delete("7"));
    }

    @Test
    public void getAll() {
        assertTrue(userRepo.getAll().size() > 0);
    }
}