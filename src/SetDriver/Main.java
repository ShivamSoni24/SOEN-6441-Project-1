package SetDriver;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Set<Person> personSet = new Set<>();

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add an element");
            System.out.println("2. Remove an element");
            System.out.println("3. Check if an element is in the set");
            System.out.println("4. Display all elements");
            System.out.println("5. Get the size of the set");
            System.out.println("6. Check if two sets are equal");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the ID of the person:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
                    System.out.println("Enter the name of the person:");
                    String name = scanner.nextLine();
                    Person person = new Person(id, name);
                    if (personSet.add(person)) {
                        System.out.println("Person added to the set.");
                    } else {
                        System.out.println("Person with the same ID already exists in the set.");
                    }
                    break;
                case 2:
                    System.out.println("Enter the ID of the person to remove:");
                    int removeId = scanner.nextInt();
                    Person removedPerson = personSet.remove(removeId);
                    if (removedPerson != null) {
                        System.out.println("Person removed from the set: " + removedPerson);
                    } else {
                        System.out.println("Person with the specified ID not found in the set.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the ID of the person to check:");
                    int checkId = scanner.nextInt();
                    if (personSet.peek(checkId)) {
                        System.out.println("Person with the specified ID found in the set.");
                    } else {
                        System.out.println("Person with the specified ID not found in the set.");
                    }
                    break;
                case 4:
                    System.out.println("Elements in the set:");
                    personSet.display();
                    break;
                case 5:
                    System.out.println("Size of the set: " + personSet.size());
                    break;
                case 6:
                    Set<Person> otherSet = new Set<>();
                    System.out.println("Creating another set...");
                    System.out.println("Enter the number of elements to add to the set:");
                    int numElements = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
                    for (int i = 0; i < numElements; i++) {
                        System.out.println("Enter the ID of the person:");
                        int otherId = scanner.nextInt();
                        scanner.nextLine(); // consume the newline character
                        System.out.println("Enter the name of the person:");
                        String otherName = scanner.nextLine();
                        Person otherPerson = new Person(otherId, otherName);
                        otherSet.add(otherPerson);
                    }
                    if (personSet.equals(otherSet)) {
                        System.out.println("The two sets are equal.");
                    } else {
                        System.out.println("The two sets are not equal.");
                    }
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
                    break;
            }
        } while (choice != 7);

        scanner.close();
    }
}