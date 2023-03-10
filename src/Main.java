import java.util.List;
import java.util.Scanner;

import controller.PropertyController;
import controller.UserController;
import models.user.Tenant;
import repository.PropertyRepoInterface;
import repository.PropertyRepository;
import repository.UserRepoInterface;
import repository.UserRepository;
import service.PropertyService;
import service.PropertySvcInterface;
import service.UserService;
import service.UserSvcInterface;

public class Main {
    public static void main(String[] args) {
        UserRepoInterface userRepo = new UserRepository();
        UserSvcInterface userSvc = new UserService(userRepo);
        UserController userController = new UserController(userSvc);

        PropertyRepoInterface propertyRepo = new PropertyRepository();
        PropertySvcInterface propertySvc = new PropertyService(propertyRepo);
        PropertyController propertyController = new PropertyController(propertySvc);

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
                    while (propertyType < 0 || propertyType > 3) {
                        System.out.println("Which property do you want to add?");
                        System.out.println("1. Apartment");
                        System.out.println("2. Condo");
                        System.out.println("3. House");
                        propertyType = Integer.parseInt(sc.nextLine());
                    }
                    String propertyId;
                    int noOfBedrooms, noOfBathrooms;
                    double squareFootArea;
                    switch (propertyType) {
                        case 1:
                            System.out.println("Enter no of bedrooms");
                            noOfBedrooms = Integer.parseInt(sc.nextLine());
                            System.out.println("Enter no of bathrooms");
                            noOfBathrooms = Integer.parseInt(sc.nextLine());
                            System.out.println("Enter square foot area");
                            squareFootArea = Double.parseDouble(sc.nextLine());

                            System.out.println("Enter apartment number");
                            int aptNo = Integer.parseInt(sc.nextLine());
                            propertyId = propertyController.addApartment(streetName, city, postalCode, province, country, aptNo, noOfBedrooms, noOfBathrooms, squareFootArea);
                            System.out.println("Apartment added with ID: " + propertyId);
                            break;
                        case 2:
                            System.out.println("Enter no of bedrooms");
                            noOfBedrooms = Integer.parseInt(sc.nextLine());
                            System.out.println("Enter no of bathrooms");
                            noOfBathrooms = Integer.parseInt(sc.nextLine());
                            System.out.println("Enter square foot area");
                            squareFootArea = Double.parseDouble(sc.nextLine());

                            System.out.println("Enter condo number");
                            int condoNo = Integer.parseInt(sc.nextLine());
                            propertyId = propertyController.addCondo(streetName, city, postalCode, province, country, condoNo, noOfBedrooms, noOfBathrooms, squareFootArea);
                            System.out.println("Apartment added with ID: " + propertyId);
                            break;
                        case 3:
                            System.out.println("Enter street number");
                            int streetNo = Integer.parseInt(sc.nextLine());
                            propertyId = propertyController.addHouse(streetName, city, postalCode, province, country, streetNo);
                            System.out.println("Apartment added with ID: " + propertyId);
                            break;
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
                case 4:
                    int propertyType = -1;
                    while (propertyType < 0) {
                        System.out.println("Please select from below option");
                        System.out.println("1. List apartments");
                        System.out.println("2. List condos");
                        System.out.println("3. List houses");
                        System.out.println("4. List all");
                        propertyType = Integer.parseInt(sc.nextLine());
                        switch (propertyType) {
                            case 1: {
                                System.out.println(propertyController.getAllApartments());
                            }
                            break;
                            case 2: {
                                System.out.println(propertyController.getAllCondos());
                            }
                            break;
                            case 3: {
                                System.out.println(propertyController.getAllHouses());
                            }
                            break;
                            case 4: {
                                System.out.println(propertyController.getAllProperties());
                            }
                            break;
                        }
                    }

                    System.out.println("--------------List of Properties--------------");
                break;
                case 5: {
                    System.out.println("--------------List of Tenants--------------");
                    List<Tenant> tenants = userController.getTenants();
                    System.out.println(tenants);
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