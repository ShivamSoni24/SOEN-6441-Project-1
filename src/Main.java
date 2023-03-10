import java.util.List;
import java.util.Scanner;

import controller.ContractController;
import controller.PropertyController;
import controller.UserController;
import models.Contract;
import models.user.Tenant;
import repository.*;
import service.*;

public class Main {
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
            System.out.println("Please select from below option");
            System.out.println("1. List apartments");
            System.out.println("2. List condos");
            System.out.println("3. List houses");
            System.out.println("4. List all");
            propertyType = Integer.parseInt(sc.nextLine());
            switch (propertyType) {
                case 1 -> {
                    System.out.println(propertyController.getAllApartments(f));
                }
                case 2 -> {
                    System.out.println(propertyController.getAllCondos(f));
                }
                case 3 -> {
                    System.out.println(propertyController.getAllHouses(f));
                }
                case 4 -> {
                    System.out.println(propertyController.getAllProperties(f));
                }
            }
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add a property");
            System.out.println("2. Add a tenant");
            System.out.println("3. Rent a unit");
            System.out.println("4. Display properties");
            System.out.println("5. Display tenants");
            System.out.println("6. Display rented units");
            System.out.println("7. Display vacant units");
            System.out.println("8. Display all leases");
            System.out.println("9. Exit");
            System.out.println("Please enter your choice: ");
            choice = sc.nextInt();

            sc.nextLine();

            switch (choice) {
                case 1: {
                    System.out.println("Enter street name");
                    String streetName = sc.nextLine();
                    System.out.println("Enter city");
                    String city = sc.nextLine();
                    System.out.println("Enter postal code");
                    String postalCode = sc.nextLine();
                    System.out.println("Enter province");
                    String province = sc.nextLine();
                    System.out.println("Enter country");
                    String country = sc.nextLine();
                    int propertyType = -1;
                    String propertyId;
                    int noOfBedrooms = 0, noOfBathrooms = 0;
                    double squareFootArea = 0.0;
                    while (propertyType < 0 || propertyType > 3) {
                        System.out.println("Which property do you want to add?");
                        System.out.println("1. Apartment");
                        System.out.println("2. Condo");
                        System.out.println("3. House");
                        propertyType = Integer.parseInt(sc.nextLine());
                    }
                    if (propertyType==1 || propertyType==2){
                        System.out.println("Enter no of bedrooms");
                        noOfBedrooms = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter no of bathrooms");
                        noOfBathrooms = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter square foot area");
                        squareFootArea = Double.parseDouble(sc.nextLine());
                    }
                    switch (propertyType) {
                        case 1 -> {
                            System.out.println("Enter apartment number");
                            int aptNo = Integer.parseInt(sc.nextLine());
                            propertyId = propertyController.addApartment(streetName, city, postalCode, province, country,
                                    aptNo, noOfBedrooms, noOfBathrooms, squareFootArea);
                            System.out.println("Apartment added with ID: " + propertyId);
                        }
                        case 2 -> {
                            System.out.println("Enter condo number");
                            int condoNo = Integer.parseInt(sc.nextLine());
                            propertyId = propertyController.addCondo(streetName, city, postalCode, province, country,
                                    condoNo, noOfBedrooms, noOfBathrooms, squareFootArea);
                            System.out.println("Apartment added with ID: " + propertyId);
                        }
                        case 3 -> {
                            System.out.println("Enter street number");
                            int streetNo = Integer.parseInt(sc.nextLine());
                            propertyId = propertyController.addHouse(streetName, city, postalCode, province, country, streetNo);
                            System.out.println("Apartment added with ID: " + propertyId);
                        }
                    }
                }
                break;
                case 2: {
                    System.out.println("Enter name");
                    String tenantName = sc.nextLine();
                    System.out.println("Enter email");
                    String tenantEmail = sc.nextLine();
                    System.out.println("Enter phone number");
                    String phoneNo = sc.nextLine();
                    String tenantId = userController.addTenant(tenantName, tenantEmail, phoneNo);
                    System.out.println("Tenant added with ID: " + tenantId);
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
                case 9:
                    System.out.println("Good bye...");
                break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);
    }
}