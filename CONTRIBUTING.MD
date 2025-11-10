# Contributing to Pet Store Management System

Thank you for your interest in contributing to the Pet Store Management System! We welcome contributions from developers of all experience levels.

## Table of Contents

- [Code of Conduct](#code-of-conduct)
- [Getting Started](#getting-started)
- [How to Contribute](#how-to-contribute)
- [Development Guidelines](#development-guidelines)
- [Coding Standards](#coding-standards)
- [Testing](#testing)
- [Pull Request Process](#pull-request-process)
- [Issue Reporting](#issue-reporting)
- [Development Setup](#development-setup)

## Code of Conduct

This project adheres to a code of conduct that we expect all contributors to follow. Please be respectful, inclusive, and professional in all interactions.

### Our Standards

- Use welcoming and inclusive language
- Be respectful of differing viewpoints and experiences
- Accept constructive criticism gracefully
- Focus on what is best for the community
- Show empathy towards other community members

## Getting Started

1. Fork the repository on GitHub
2. Clone your fork locally:
   ```bash
   git clone https://github.com/YOUR_USERNAME/PetStoreManagement.git
   cd PetStoreManagement
   ```
3. Create a new branch for your feature or bugfix:
   ```bash
   git checkout -b feature/your-feature-name
   ```

## How to Contribute

### Types of Contributions

We welcome several types of contributions:

- **Bug fixes**: Fix existing issues in the codebase
- **Feature additions**: Add new functionality to the system
- **Documentation improvements**: Enhance README, comments, or create new documentation
- **Code refactoring**: Improve code structure and maintainability
- **Performance optimizations**: Enhance application performance
- **Test coverage**: Add unit tests or integration tests

### Before You Start

- Check existing issues to avoid duplicating work
- For major changes, create an issue first to discuss the proposed changes
- Make sure your development environment is set up correctly

## Development Guidelines

### Project Structure

Follow the existing project structure:
```
src/main/java/com/petstore/
├── Pet.java          # Abstract base class
├── Dog.java          # Dog implementation
├── Cat.java          # Cat implementation  
├── Clinic.java       # Clinic management
└── Petstore.java     # Main application
```

### Adding New Pet Types

To add a new pet type (e.g., Bird, Fish):

1. Create a new class extending `Pet`
2. Implement required abstract methods
3. Add the new pet type to the main menu in `Petstore.java`
4. Update documentation

Example:
```java
package com.petstore;

public class Bird extends Pet {
    private String species;
    
    public Bird(String name, int age, String colour, double weight, String species) {
        super(name, age, colour, weight);
        this.species = species;
    }
    
    @Override
    public String speak() {
        return "Tweet! I am " + name + ", a " + age + " year old " + species;
    }
    
    // Additional bird-specific methods
}
```

## Coding Standards

### Java Conventions

- Follow Oracle's Java naming conventions
- Use camelCase for variables and methods
- Use PascalCase for class names
- Use UPPER_CASE for constants

### Code Style

- **Indentation**: Use 4 spaces (no tabs)
- **Line length**: Maximum 120 characters
- **Braces**: Opening brace on same line
- **Comments**: Use JavaDoc for public methods and classes

### Example Code Style

```java
package com.petstore;

/**
 * Represents a pet in the clinic system.
 * This is an abstract base class for all pet types.
 */
public abstract class Pet {
    protected String name;
    protected int age;
    
    /**
     * Creates a new pet with the specified attributes.
     * @param name The pet's name
     * @param age The pet's age in years
     */
    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    /**
     * Returns the sound this pet makes.
     * @return A string representation of the pet's sound
     */
    public abstract String speak();
}
```

### Variable Naming

- Use descriptive names: `petName` instead of `n`
- Avoid abbreviations: `petWeight` instead of `petWt`
- Boolean variables should start with `is`, `has`, or `can`

## Testing

### Manual Testing

Before submitting your contribution:

1. Compile the code without errors:
   ```bash
   javac -d . src/main/java/com/petstore/*.java
   ```

2. Test all menu options:
    - Add pets (both dogs and cats)
    - View all pets
    - Search functionality
    - Modify pet information
    - Delete pets
    - Generate clinic reports
    - Exit and verify data persistence

3. Test edge cases:
    - Empty pet lists
    - Invalid input handling
    - Boundary values (negative ages, weights)

### Future Testing Framework

We plan to implement JUnit tests. Contributors are welcome to add test cases following these patterns:

```java
// Future test example
@Test
public void testAddPet() {
    Pet dog = new Dog("Buddy", 3, "Brown", 25.5, "Golden Retriever");
    assertEquals("Buddy", dog.getName());
    assertEquals(3, dog.getAge());
}
```

## Pull Request Process

### Before Submitting

1. Ensure your code follows the coding standards
2. Test your changes thoroughly
3. Update documentation if necessary
4. Add comments explaining complex logic

### Pull Request Guidelines

1. **Title**: Use a clear, descriptive title
    - Good: "Add Bird class with species attribute"
    - Bad: "Update code"

2. **Description**: Include:
    - What changes were made
    - Why the changes were necessary
    - How to test the changes
    - Screenshots (if applicable)

3. **Commits**:
    - Use meaningful commit messages
    - Keep commits atomic (one logical change per commit)
    - Follow format: "verb: description"

   Examples:
   ```
   feat: add Bird class for avian pets
   fix: resolve null pointer exception in pet search
   docs: update README with new installation steps
   refactor: simplify pet creation logic
   ```

### Pull Request Template

```markdown
## Description
Brief description of changes made.

## Type of Change
- [ ] Bug fix
- [ ] New feature
- [ ] Documentation update
- [ ] Refactoring
- [ ] Performance improvement

## Testing
- [ ] Manual testing completed
- [ ] All menu options verified
- [ ] Edge cases tested

## Checklist
- [ ] Code follows project style guidelines
- [ ] Comments added for complex logic
- [ ] Documentation updated (if needed)
- [ ] No compilation errors
```

## Issue Reporting

### Bug Reports

When reporting bugs, include:

1. **Environment**: Java version, OS
2. **Steps to reproduce**: Detailed steps
3. **Expected behavior**: What should happen
4. **Actual behavior**: What actually happens
5. **Error messages**: Any console output or stack traces

### Feature Requests

For new features, provide:

1. **Use case**: Why is this feature needed?
2. **Proposed solution**: How should it work?
3. **Alternatives**: Other possible approaches
4. **Additional context**: Screenshots, mockups, etc.

## Development Setup

### Required Tools

- **Java JDK 8+**: For compilation and runtime
- **Text Editor/IDE**: IntelliJ IDEA, Eclipse, or VS Code recommended
- **Git**: For version control
- **Terminal/Command Prompt**: For running commands

### IDE Setup

#### IntelliJ IDEA
1. Open project folder
2. Set JDK version (File → Project Structure → Project)
3. Configure code style (File → Settings → Code Style → Java)

#### VS Code
1. Install Java Extension Pack
2. Open project folder
3. Configure Java path in settings

### Building and Running

```bash
# Compile all Java files
javac -d . src/main/java/com/petstore/*.java

# Run the application
java com.petstore.Petstore

# Clean compiled files (if needed)
find . -name "*.class" -delete
```

## Git Workflow

### Branch Naming

Use descriptive branch names:
- `feature/add-bird-support`
- `bugfix/null-pointer-search`
- `docs/update-readme`
- `refactor/simplify-menu-logic`

### Commit Messages

Follow conventional commit format:
```
type(scope): description

[optional body]

[optional footer]
```

Types:
- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation changes
- `style`: Code style changes
- `refactor`: Code refactoring
- `test`: Adding tests
- `chore`: Maintenance tasks

## Questions and Support

- **Issues**: Use GitHub issues for bug reports and feature requests
- **Discussions**: Use GitHub discussions for questions and general discussion
- **Documentation**: Check README.md and code comments first

## Recognition

Contributors will be acknowledged in:
- GitHub contributor list
- Future releases changelog
- Project documentation

Thank you for contributing to the Pet Store Management System! 🐾
