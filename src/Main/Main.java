package Main;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import Main.controller.ContractController;
import Main.controller.PropertyController;
import Main.controller.UserController;
import Main.models.Contract;
import Main.models.user.Tenant;
import Main.repository.*;
import Main.service.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {
    // Injecting dependencies
    public static UserRepoInterface userRepo = new UserRepository();
    public static UserSvcInterface userSvc = new UserService(userRepo);
    public static UserController userController = new UserController(userSvc);

    public static PropertyRepoInterface propertyRepo = new PropertyRepository();
    public static PropertySvcInterface propertySvc = new PropertyService(propertyRepo);
    public static PropertyController propertyController = new PropertyController(propertySvc);

    public static ContractRepoInterface contractRepo = new ContractRepository();
    public static ContractSvcInterface contractSvc = new ContractService(userRepo, propertyRepo, contractRepo);
    public static ContractController contractController = new ContractController(contractSvc);

    private static void listProperties(Scanner sc, Filter f){
        int propertyType = -1;
        while (propertyType < 0) {
            System.out.println("\nPlease select from below option");
            System.out.println("1. List apartments");
            System.out.println("2. List condos");
            System.out.println("3. List houses");
            System.out.println("4. List all");
            System.out.print("Enter your choice: ");
            propertyType = Integer.parseInt(sc.nextLine());
            switch (propertyType) {
                case 1 ->
                    System.out.println(propertyController.getAllApartments(f));
                case 2 ->
                    System.out.println(propertyController.getAllCondos(f));
                case 3 ->
                    System.out.println(propertyController.getAllHouses(f));
                case 4 ->
                    System.out.println(propertyController.getAllProperties(f));
            }
        }
    }
    public static void cmdExecution() {

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Add a property");
            System.out.println("2. Add a tenant");
            System.out.println("3. Create contract");
            System.out.println("4. Display properties");
            System.out.println("5. Display tenants");
            System.out.println("6. Display rented units");
            System.out.println("7. Display vacant units");
            System.out.println("8. Display all leases");
            System.out.println("9. Cancel contract");
            System.out.println("10. Enter tenant interest");
            System.out.println("11. Get rent status");
            System.out.println("12. Pay rent");
            System.out.println("13. Exit");
            System.out.print("Please enter your choice: ");
            choice = sc.nextInt();

            sc.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("\nEnter street name: ");
                    String streetName = sc.nextLine();
                    System.out.print("Enter city: ");
                    String city = sc.nextLine();
                    System.out.print("Enter postal code: ");
                    String postalCode = sc.nextLine();
                    System.out.print("Enter province: ");
                    String province = sc.nextLine();
                    System.out.print("Enter country: ");
                    String country = sc.nextLine();
                    int propertyType = -1;
                    String propertyId;
                    int noOfBedrooms = 0, noOfBathrooms = 0;
                    double squareFootArea = 0.0;
                    while (propertyType < 0 || propertyType > 3) {
                        System.out.println("\nWhich property do you want to add?");
                        System.out.println("1. Apartment");
                        System.out.println("2. Condo");
                        System.out.println("3. House");
                        System.out.print("Enter your choice: ");
                        propertyType = Integer.parseInt(sc.nextLine());
                    }
                    if (propertyType==1 || propertyType==2){
                        System.out.print("\nEnter no of bedrooms: ");
                        noOfBedrooms = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter no of bathrooms: ");
                        noOfBathrooms = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter square foot area: ");
                        squareFootArea = Double.parseDouble(sc.nextLine());
                    }
                    switch (propertyType) {
                        case 1 -> {
                            System.out.print("Enter apartment number: ");
                            int aptNo = Integer.parseInt(sc.nextLine());
                            propertyId = propertyController.addApartment(streetName, city, postalCode, province, country,
                                    aptNo, noOfBedrooms, noOfBathrooms, squareFootArea);
                            System.out.println("\nApartment added with property ID: " + propertyId);
                        }
                        case 2 -> {
                            System.out.print("Enter condo number: ");
                            int condoNo = Integer.parseInt(sc.nextLine());
                            propertyId = propertyController.addCondo(streetName, city, postalCode, province, country,
                                    condoNo, noOfBedrooms, noOfBathrooms, squareFootArea);
                            System.out.println("\nCondo added with property ID: " + propertyId);
                        }
                        case 3 -> {
                            System.out.print("Enter street number: ");
                            int streetNo = Integer.parseInt(sc.nextLine());
                            propertyId = propertyController.addHouse(streetName, city, postalCode, province, country, streetNo);
                            System.out.println("\nHouse added with property ID: " + propertyId);
                        }
                    }
                }
                break;
                case 2: {
                    System.out.print("\nEnter name: ");
                    String tenantName = sc.nextLine();
                    System.out.print("Enter email: ");
                    String tenantEmail = sc.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNo = sc.nextLine();
                    String tenantId = userController.addTenant(tenantName, tenantEmail, phoneNo);
                    System.out.println("\nTenant added with user ID: " + tenantId);
                }
                break;
                case 3:{
                    System.out.print("\nEnter tenant ID: ");
                    String tenantId = sc.nextLine();
                    System.out.print("Enter property ID: ");
                    String propertyId = sc.nextLine();

                    System.out.print("Enter duration of contract in months: ");
                    int months = Integer.parseInt(sc.nextLine());
                    LocalDate endDate = LocalDate.now().plusMonths(months);

                    System.out.print("Enter monthly rate: ");
                    double monthlyRate = Double.parseDouble(sc.nextLine());
                    try {
                        contractController.rentUnit(tenantId, propertyId, endDate, monthlyRate);
                    } catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
                case 4: {
                    System.out.println("--------------List of Properties--------------");
                    listProperties(sc, Filter.ALL);
                }
                break;
                case 5: {
                    System.out.println("--------------List of Tenants--------------");
                    List<Tenant> tenants = userController.getTenants();
                    System.out.println(tenants);
                }
                break;
                case 6: {
                    System.out.println("--------------List of rented Properties--------------");
                    listProperties(sc, Filter.RENTED);
                }
                break;
                case 7:  {
                    System.out.println("--------------List of vacant Properties--------------");
                    listProperties(sc, Filter.VACANT);
                }
                break;
                case 8: {
                    System.out.println("--------------List of leases--------------");
                    List<Contract> contracts = contractController.getLeases();
                    System.out.println(contracts);
                }
                break;
                case 9: {
                    System.out.print("\nEnter tenant ID: ");
                    String tenantId = sc.nextLine();
                    System.out.print("Enter property ID: ");
                    String propertyId = sc.nextLine();

                    try {
                        contractController.terminateContract(propertyId, tenantId);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
                case 10: {
                    System.out.print("\nEnter tenant ID: ");
                    String tenantId = sc.nextLine();
                    System.out.print("Enter property ID: ");
                    String propertyId = sc.nextLine();

                    try {
                        contractController.registerInterest(propertyId, tenantId);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
                case 11: {
                    System.out.print("\nEnter tenant ID: ");
                    String tenantId = sc.nextLine();
                    System.out.print("Enter property ID: ");
                    String propertyId = sc.nextLine();
                    System.out.print("Enter month for which you want to check the rent status: ");
                    int month = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter year for which you want to check the rent status: ");
                    int year = Integer.parseInt(sc.nextLine());

                    try {
                        boolean rentStatus = contractController.getRentStatus(propertyId, tenantId, month, year);
                        System.out.println(rentStatus ? "\nRent is paid\n" : "\nRent is not paid\n");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                
                break;
                case 12: {
                    System.out.print("\nEnter tenant ID: ");
                    String tenantId = sc.nextLine();
                    System.out.print("Enter property ID: ");
                    String propertyId = sc.nextLine();
                    System.out.print("Enter month for which you want pay the rent: ");
                    int month = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter year for which you want to pay the rent: ");
                    int year = Integer.parseInt(sc.nextLine());

                    try {
                        boolean rentStatus = contractController.getRentStatus(propertyId, tenantId, month, year);
                        if (rentStatus) {
                            System.out.println("\nRent is already paid\n");
                        } else {
                            contractController.setRentStatus(propertyId, tenantId, month, year);
                            System.out.println("\nRent paid successfully\n");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
                case 13:
                    System.out.println("Good bye...");
                break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 13);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("views/home/home-view.fxml")));

        // Create a new scene with the root node as the parent
        Scene scene = new Scene(root, 800, 600);

        // Set the title of the stage
        primaryStage.setTitle("The Boyz Company");

        // Set the scene for the stage
        primaryStage.setScene(scene);

        // Fix the window size
        primaryStage.setResizable(false);

        // Show the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        // launching the GUI
        launch(args);
    }
}