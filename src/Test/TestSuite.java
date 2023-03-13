package Test;

import Main.controller.ContractController;
import Main.controller.PropertyController;
import Main.controller.UserController;
import Main.repository.*;
import Main.service.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import java.time.LocalDate;

@RunWith(Suite.class)
@SuiteClasses({ContractControllerTest.class, PropertyControllerTest.class, UserControllerTest.class,
        ContractServiceTest.class, PropertyServiceTest.class, UserServiceTest.class,
        ContractRepositoryTest.class, PropertyRepositoryTest.class, UserRepositoryTest.class})
public class TestSuite {

    private static boolean isSetupDone = false;
    public static UserRepoInterface userRepo;
    public static UserSvcInterface userSvc;
    public static UserController userController;
    public static PropertyRepoInterface propertyRepo;
    public static PropertySvcInterface propertySvc;
    public static PropertyController propertyController;
    public static ContractRepoInterface contractRepo;
    public static ContractSvcInterface contractSvc;
    public static ContractController contractController;
    @BeforeClass
    public static void setup() throws Exception {
        if(!isSetupDone) {
            // Injecting dependencies
            userRepo = new UserRepository();
            userSvc = new UserService(userRepo);
            userController = new UserController(userSvc);

            propertyRepo = new PropertyRepository();
            propertySvc = new PropertyService(propertyRepo);
            propertyController = new PropertyController(propertySvc);

            contractRepo = new ContractRepository();
            contractSvc = new ContractService(userRepo, propertyRepo, contractRepo);
            contractController = new ContractController(contractSvc);

            // Creating User repository
            userController.addTenant("Chandler Bing", "CMB@gmail.com", "7894561230");
            userController.addTenant("Joey Tribbiani", "JT@gmail.com", "4561230789");
            userController.addTenant("Ross Gellar", "RS@gmail.com", "1237894560");
            userController.addTenant("Monica Gellar", "GCM@gmail.com", "1237498560");
            userController.addTenant("Rachel Green", "RRG@gmail.com", "8837894560");
            userController.addTenant("Pheobe Buffay", "PMB@gmail.com", "1777894560");

            // Creating Property repository
            propertyController.addApartment("2000 Marc", "Montreal", "H3H 2N9", "QC", "CA", 506, 1, 1, 520.5);
            propertyController.addApartment("2000 Marc", "Montreal", "H3H 2N9", "QC", "CA", 1905, 1, 1, 550.5);
            propertyController.addCondo("1645 Marc", "Montreal", "H3H 2N7", "QC", "CA", 2005, 2, 2, 800);
            propertyController.addCondo("1645 Marc", "Montreal", "H3H 2N7", "QC", "CA", 1504, 2, 1, 650);
            propertyController.addHouse("Catherine", "Montreal", "H3H 2N7", "QC", "CA", 1826);
            propertyController.addHouse("Jean-Talon", "Montreal", "H3H 2N7", "QC", "CA", 221);

            // Creating relations
            contractController.rentUnit("1", "1", LocalDate.of(2023, 5, 25), 1367);
            contractController.rentUnit("3", "3", LocalDate.of(2023, 6, 26), 1690);
            contractController.rentUnit("6", "6", LocalDate.of(2023, 4, 21), 2600);

            // Adding the admin (id = 7)
            userController.addAdmin("The Boys Company", "TheBoys@gmail.com", "1759324860");

            // Case 1: Test rent status
            contractController.setRentStatus("1", "1", 2, 2023);

            isSetupDone = true;
        }
    }

    @AfterClass
    public static void teardown() {
    }
}
