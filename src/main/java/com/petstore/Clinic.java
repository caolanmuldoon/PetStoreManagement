package com.petstore;

import java.util.*;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;

class Clinic {
    private String clinicName = "Happy Paws Clinic";
    private ArrayList<Pet> pets = new ArrayList<>();

    public void addPet(Pet pet) {
        pets.add(pet);
        System.out.println("Pet added successfully!");
    }

    public void viewAllPets() {
        if (pets.isEmpty()) {
            System.out.println("No pets registered.");
        } else {
            for (Pet pet : pets) {
                System.out.println(pet.getDetails());
            }
        }
    }

    public void searchPet(String searchTerm) {
        boolean found = false;
        for (Pet pet : pets) {
            if (pet.name.equalsIgnoreCase(searchTerm) || pet.colour.equalsIgnoreCase(searchTerm)) {
                System.out.println(pet.getDetails());
                System.out.println(pet.speak());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No pet found with that name or color.");
        }
    }

    public void deletePet(String name) {
        Iterator<Pet> iterator = pets.iterator();
        while (iterator.hasNext()) {
            Pet pet = iterator.next();
            if (pet.name.equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println("Pet deleted successfully.");
                return;
            }
        }
        System.out.println("No pet found with that name.");
    }

    public void modifyPet(String name, Scanner scanner) {
        for (Pet pet : pets) {
            if (pet.name.equalsIgnoreCase(name)) {
                System.out.print("Enter new age: ");
                pet.age = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter new colour: ");
                pet.colour = scanner.nextLine();

                System.out.print("Enter new weight: ");
                pet.weight = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Pet details updated successfully.");
                return;
            }
        }
        System.out.println("No pet found with that name.");
    }

    public void reportClinicStatus() {
        int dogCount = 0;
        int catCount = 0;
        HashMap<String, Integer> colorFrequency = new HashMap<>();

        for (Pet pet : pets) {
            if (pet instanceof Dog) {
                dogCount++;
            } else if (pet instanceof Cat) {
                catCount++;
            }
            colorFrequency.put(pet.colour.toLowerCase(), colorFrequency.getOrDefault(pet.colour.toLowerCase(), 0) + 1);
        }

        String dominantColor = "None";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : colorFrequency.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                dominantColor = entry.getKey();
            }
        }

        System.out.println("\n--- Clinic Report ---");
        System.out.println("Clinic Name: " + clinicName);
        System.out.println("Total Dogs: " + dogCount);
        System.out.println("Total Cats: " + catCount);
        System.out.println("Dominant Color: " + dominantColor);

        try (PrintWriter writer = new PrintWriter(new FileWriter("ClinicReport.txt"))) {
            writer.println("--- Clinic Report ---");
            writer.println("Clinic Name: " + clinicName);
            writer.println("Total Dogs: " + dogCount);
            writer.println("Total Cats: " + catCount);
            writer.println("Dominant Color: " + dominantColor);
            System.out.println("Clinic report saved to ClinicReport.txt");
        } catch (IOException e) {
            System.out.println("Error writing report to file: " + e.getMessage());
        }
    }

    public void saveDataToFile() {
        try {
            // Save clinic details (clinicName, total number of pets)
            FileWriter clinicWriter = new FileWriter("ClinicsDetails.txt");
            clinicWriter.write("Clinic Name: " + clinicName + "\n");
            clinicWriter.write("Total Pets: " + pets.size() + "\n");
            clinicWriter.close();

            // Append to the PetDetails.txt file
            FileWriter petWriter = new FileWriter("PetDetails.txt", true);  // 'true' enables append mode
            for (Pet pet : pets) {
                if (pet.name.length() == 0 || pet.colour.length() == 0 || pet.age <= 0 || pet.weight <= 0) {
                    continue; // skip invalid records
                }

                String line;
                if (pet instanceof Dog) {
                    Dog dog = (Dog) pet;
                    line = "Dog," + dog.name + "," + dog.age + "," + dog.colour + "," + dog.weight + "," + dog.getBreed();
                } else if (pet instanceof Cat) {
                    Cat cat = (Cat) pet;
                    line = "Cat," + cat.name + "," + cat.age + "," + cat.colour + "," + cat.weight + "," + cat.getBreed();
                } else {
                    continue;
                }

                petWriter.write(line + "\n");
            }
            petWriter.close();

            System.out.println("Clinic and pet data saved to files.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }


    public void loadDataFromFile() {
        try {
            // Load clinic details from ClinicsDetails.txt
            BufferedReader clinicReader = new BufferedReader(new FileReader("ClinicsDetails.txt"));
            String line;
            while ((line = clinicReader.readLine()) != null) {
                if (line.startsWith("Clinic Name:")) {
                    clinicName = line.split(":")[1].trim();
                }
            }
            clinicReader.close();

            // Load pet details from PetDetails.txt
            BufferedReader petReader = new BufferedReader(new FileReader("PetDetails.txt"));
            while ((line = petReader.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length >= 6) {
                    String petType = details[0].trim();
                    String name = details[1].trim();
                    int age = Integer.parseInt(details[2].trim());
                    String colour = details[3].trim();
                    double weight = Double.parseDouble(details[4].trim());
                    String breed = details[5].trim();

                    if (petType.equalsIgnoreCase("Dog")) {
                        pets.add(new Dog(name, age, colour, weight, breed));
                    } else if (petType.equalsIgnoreCase("Cat")) {
                        pets.add(new Cat(name, age, colour, weight, breed));
                    }
                }
            }
            petReader.close();

            System.out.println("Clinic and pet data loaded from files.");
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
