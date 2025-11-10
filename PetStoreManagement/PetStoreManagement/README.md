# Pet Store Management System

A Java-based console application for managing pets in a veterinary clinic or pet store. This system allows users to add, view, search, modify, and delete pet records, as well as generate clinic reports.

## Features

- **Pet Management**: Add, view, search, modify, and delete pet records
- **Multi-Pet Support**: Handle both dogs and cats with breed-specific information
- **Search Functionality**: Search pets by name or color
- **Clinic Reports**: Generate comprehensive reports on clinic status
- **Data Persistence**: Automatic saving of pet and clinic data to files
- **Interactive Menu**: User-friendly console interface

## Pet Types Supported

### Dogs
- Name, age, color, weight
- Breed information
- Custom speak behavior

### Cats
- Name, age, color, weight
- Breed information
- Custom speak behavior

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Command line interface (Terminal, Command Prompt, etc.)

### Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd PetStoreManagement
   ```

2. Compile the Java files:
   ```bash
   javac -d . src/main/java/com/petstore/*.java
   ```

3. Run the application:
   ```bash
   java com.petstore.Petstore
   ```

## Usage

When you run the application, you'll see a menu with the following options:

```
1. Add Pet
2. View All Pets
3. Search Pet
4. Delete Pet
5. Modify Pet
6. Clinic Report
7. Exit
```

### Adding a Pet

1. Select option 1 from the main menu
2. Choose the pet type (Dog or Cat)
3. Enter the required information:
    - Name
    - Age
    - Color
    - Weight
    - Breed

### Viewing Pets

Select option 2 to display all pets currently registered in the clinic with their complete information.

### Searching for Pets

Select option 3 and choose to search by:
- Pet name
- Pet color

### Modifying Pet Information

1. Select option 4
2. Enter the pet's name
3. Update the desired information

### Deleting a Pet

1. Select option 5
2. Enter the name of the pet to remove

### Clinic Reports

Select option 6 to view comprehensive clinic statistics and reports.

### Exiting

Select option 7 to save all data and exit the application safely.

## Project Structure

```
PetStoreManagement/
├── README.md
├── CONTRIBUTING.md
└── src/
    └── main/
        └── java/
            └── com/
                └── petstore/
                    ├── Pet.java          # Abstract base class for all pets
                    ├── Dog.java          # Dog implementation
                    ├── Cat.java          # Cat implementation
                    ├── Clinic.java       # Clinic management functionality
                    └── Petstore.java     # Main application class
```

## Class Overview

- **Pet.java**: Abstract base class defining common pet properties and behaviors
- **Dog.java**: Concrete implementation for dog pets with breed-specific features
- **Cat.java**: Concrete implementation for cat pets with breed-specific features
- **Clinic.java**: Handles clinic operations, reports, and data management
- **Petstore.java**: Main class with user interface and application flow

## Data Storage

The application automatically saves data to files when exiting:
- Pet information is preserved between sessions
- Clinic data and statistics are maintained

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct and the process for submitting pull requests.

## Future Enhancements

- Database integration for better data persistence
- Additional pet types (birds, fish, reptiles)
- Appointment scheduling system
- Medical records tracking
- Vaccination reminder system
- Owner contact management

## License

This project is open source and available under the [MIT License](LICENSE).

## Support

If you encounter any issues or have questions, please create an issue in the repository or contact the development team.

---

**Note**: This is an educational project designed to demonstrate object-oriented programming principles in Java, including inheritance, polymorphism, and encapsulation.

