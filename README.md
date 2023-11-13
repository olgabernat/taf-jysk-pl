# TAF - Automated Testing Framework for https://jysk.pl/

## Overview
The project is an automated testing framework designed for testing the jysk.pl website, which offers a variety of home goods.

## Technical Requirements

- **Programming Language:** Java
- **Unit Testing Framework:** Used one of the popular unit testing frameworks
- **Best Practices:** Followed best practices and coding conventions
- **Version Control:** Project hosted on a remote repository https://github.com/olgabernat/taf-jysk-pl

## Project Structure
### Test Automation

The project encompasses both UI (User Interface) and API (Application Programming Interface) testing for the JYSK website.

### Maven Integration

The project is managed using Maven for dependency management and project build.

### Technologies and Tools

- Java
- Selenium WebDriver
- Unit Testing Framework
- Page Object Model (POM)
- API testing libraries
- Maven for dependency management and build
- Jenkins for continuous integration
- Reporting tools for local test execution and report generation

### Test Classes

#### API Tests

- `BaseUrlTest`: Tests related to the base URL of the API.
- `LoginTest`: Tests related to user login through the API.
- `SearchApiTests`:  API tests for the search functionality.

#### UI Tests

- `BaseTest`: Base test class for common functionalities.
- `HomePageTest`: Tests related to the homepage of the jysk.pl website.
- `SearchTest`: Tests related to the search functionality.
- `LoginPageTest`: Tests related to the user login functionality.
- `SearchTest`: Tests related to the search functionality.

### Java Classes

- `ChairPage`: Represents the page functionality related to chairs.
- `ChairPageLocators`: Contains locators for elements on the chair page.
- `HomePage`: Represents the functionality of the homepage.
- `HomePageLocators`: Contains locators for elements on the homepage.
- `LoginPage`: Represents the functionality of the login page.
- `LoginPageLocators`: Contains locators for elements on the login page.

## How to Run the Tests

1. Clone the project repository.
2. Ensure you have Java and Maven installed.
3. Run the following command to execute the tests: `mvn clean test`

## Jenkins Integration

Jenkins job has been set up to download the project every 9 minutes and run the tests.

## Reporting

Reporting is integrated into the project, allowing local test execution and report generation.

The project is maintained by Olga Bernat.
Feel free to explore the project and contribute to its improvement!