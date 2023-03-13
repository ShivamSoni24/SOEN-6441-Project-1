package Test;

import Main.models.user.Tenant;
import org.junit.Test;

import static Test.TestSuite.userSvc;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test
    public void getTenant() {
        assertTrue(userSvc.getTenant("1") instanceof Tenant);
    }

    @Test
    public void getTenants() {
        assertNotNull(userSvc.getTenants());
    }

    @Test
    public void getAdmins() {
        assertTrue(userSvc.getAdmins().size() > 0);
    }
}