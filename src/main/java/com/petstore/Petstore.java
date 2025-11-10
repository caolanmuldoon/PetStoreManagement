package com.petstore;

import java.util.*;

/**
 * Main application class for the Pet Store Management System.
 * This class provides a console-based interface for managing pets in a veterinary clinic.
 *
 * Features include:
 * - Adding new pets (Dogs and Cats)
 * - Viewing all registered pets
 * - Searching for pets by name or color
 * - Deleting pets from the system
 * - Modifying pet information
 * - Generating clinic reports
 * - Data persistence to file
 *
 */
public class Petstore {

    /**
     * Main entry point of the application.
     * Initializes the scanner for user input and clinic management system,
     * then starts the interactive menu loop.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Initialize scanner for reading user input
        Scanner scanner = new Scanner(System.in);
        // Initialize clinic management system
        Clinic clinic = new Clinic();

        // Main application loop - continues until user chooses to exit
        while (true) {
            // Display main menu options to the user
            System.out.println("\n=== Pet Store Management System ===");
            System.out.println("1. Add Pet\n2. View All Pets\n3. Search Pet\n4. Delete Pet\n5. Modify Pet\n6. Clinic Report\n7. Exit");
            System.out.print("Please select an option (1-7): ");

            // Read user's menu choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            // Process user's choice using switch statement
            switch (choice) {
                case 1: // Add new pet to the clinic
                    System.out.println("\n--- Adding New Pet ---");

                    // Get pet type from user (Dog or Cat)
                    System.out.print("Enter pet type (Dog/Cat): ");
                    String type = scanner.nextLine();

                    // Collect basic pet information
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline after integer input

                    System.out.print("Enter colour: ");
                    String colour = scanner.nextLine();

                    System.out.print("Enter weight (kg): ");
                    double weight = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline after double input

                    System.out.print("Enter breed: ");
                    String breed = scanner.nextLine();

                    // Create appropriate pet object based on type and add to clinic
                    if (type.equalsIgnoreCase("Dog")) {
                        clinic.addPet(new Dog(name, age, colour, weight, breed));
                    } else if (type.equalsIgnoreCase("Cat")) {
                        clinic.addPet(new Cat(name, age, colour, weight, breed));
                    } else {
                        System.out.println("Invalid pet type. Please enter 'Dog' or 'Cat'.");
                    }
                    break;

                case 2: // Display all pets currently registered in the clinic
                    System.out.println("\n--- All Registered Pets ---");
                    clinic.viewAllPets();
                    break;

                case 3: // Search for pets by name or color
                    System.out.println("\n--- Pet Search ---");
                    System.out.print("Enter name or color to search: ");
                    String searchTerm = scanner.nextLine();
                    clinic.searchPet(searchTerm);
                    break;

                case 4: // Remove a pet from the clinic system
                    System.out.println("\n--- Delete Pet ---");
                    System.out.print("Enter the name of the pet to delete: ");
                    String deleteName = scanner.nextLine();
                    clinic.deletePet(deleteName);
                    break;

                case 5: // Modify existing pet information
                    System.out.println("\n--- Modify Pet Information ---");
                    System.out.print("Enter the name of the pet to modify: ");
                    String modifyName = scanner.nextLine();
                    clinic.modifyPet(modifyName, scanner);
                    break;

                case 6: // Generate and display clinic status report
                    System.out.println("\n--- Clinic Status Report ---");
                    clinic.reportClinicStatus();
                    break;

                case 7: // Exit the application with data persistence
                    System.out.println("\n--- Shutting Down System ---");
                    clinic.saveDataToFile(); // Save all data before exiting
                    System.out.println("Data saved successfully!");
                    System.out.println("Thank you for using Pet Store Management System. Goodbye!");
                    return; // Exit the main method and terminate the program

                default: // Handle invalid menu selections
                    System.out.println("Invalid choice. Please select a number between 1 and 7.");
            }
        }
    }
}
