package Test;

import Main.models.user.Tenant;
import Main.models.user.User;
import org.junit.Test;

import static Test.TestSuite.userController;
import static org.junit.jupiter.api.Assertions.*;

public class UserControllerTest {

    @Test
    public void getTenants() {
        assertTrue(userController.getTenants().get(0) instanceof Tenant);
    }

    @Test
    public void getAdmins() {
        assertFalse(userController.getAdmins() instanceof User);
    }
}