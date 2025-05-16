# MavenTestKombined  

**MavenTestKombined** is a **Java-based Behavior-Driven Development (BDD)** testing framework utilizing **JUnit, Cucumber, and Selenium WebDriver** for automated UI testing. It follows a scalable and maintainable architecture to ensure efficient test execution.

## Key Features
- **BDD with Cucumber** – Step definitions (`LoginSteps.java`) and feature files (`Login.feature`).
- **Page Object Model (POM)** – Centralized UI elements in `LoginPage.java`.
- **Selenium WebDriver Integration** – UI automation tests executed via `TestRunner.java`.
- **Automated Driver Management** – Uses `WebDriverManager` for streamlined browser execution.

## Project Structure Overview
- `src/test/java` – Test classes including step definitions, hooks, and page objects.
- `src/test/resources/features` – Gherkin-based feature files for BDD test scenarios.
- `screenshots` – Stores test execution images.
- `pom.xml` – Maven dependencies and configurations.

## CI/CD Pipeline with GitHub Actions   
To ensure continuous integration and automated testing, **MavenTestKombined** utilizes **GitHub Actions** for its **CI/CD pipeline**.  

### **How It Works:**
1. **Triggers** – The pipeline runs automatically on each `push` or `pull request` to the `main` branch.  
2. **Environment Setup** – It sets up **JDK 17**, downloads project dependencies, and initializes the Maven build.  
3. **Automated Testing** – Runs all tests using:  
   ```bash
   mvn -B test

