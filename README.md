# Senior QA Automation Portfolio

A comprehensive QA automation portfolio demonstrating practical implementation of
UI automation, API testing, database validation, BDD, CI/CD, reporting, and
automation framework design.

The project is built primarily using Java, Selenium WebDriver, TestNG,
REST Assured, JDBC/MySQL, Cucumber BDD, Maven, GitHub Actions, Extent Reports,
and Log4j2.

The framework demonstrates maintainable automation practices including
Page Object Model (POM), reusable utilities, workflow abstraction,
data-driven testing, retry handling, cross-browser support,
failure screenshots, structured logging, and automated CI execution.

## Automation Coverage

### UI Automation
- Selenium WebDriver with Java
- Page Object Model (POM)
- Reusable ElementUtils
- Business workflow abstraction
- TestNG DataProvider
- Excel-based test data using Apache POI
- Retry mechanism using IRetryAnalyzer
- Cross-browser WebDriver support
- ThreadLocal WebDriver management
- Headless execution in CI
- Automatic screenshots on test failure

### API Automation
- REST Assured
- GET, POST, PUT, and DELETE request validation
- HTTP status-code validation
- JSON response validation
- TestNG integration

### Database Testing
- JDBC integration with MySQL
- Database connection validation
- PreparedStatement usage
- Backend data verification
- SQL joins and data-integrity validation
- Automated MySQL service initialization in CI

### BDD
- Cucumber with TestNG
- Gherkin feature files
- Step definitions
- End-to-end insurance quote scenario
- Cucumber HTML reporting

### Reporting & Logging
- Extent Reports HTML reporting
- Test pass/fail reporting
- Failure screenshot capture
- Log4j2 structured logging
- Console and file-based logging

### CI/CD
- GitHub Actions
- Maven automated test execution
- Java 17 CI environment
- MySQL service container
- Automated database initialization
- Headless Selenium execution
- Failure screenshot artifacts
- Extent Report artifacts
- Cucumber HTML report artifact

## Technology Stack

| Area | Technologies |
|---|---|
| Programming | Java 17 |
| UI Automation | Selenium WebDriver |
| Test Framework | TestNG |
| BDD | Cucumber |
| API Automation | REST Assured |
| Database | MySQL, JDBC, SQL |
| Test Data | Apache POI, Excel |
| Build Tool | Maven |
| Reporting | Extent Reports, Cucumber HTML Report |
| Logging | Log4j2 |
| CI/CD | GitHub Actions |
| Version Control | Git, GitHub |
| Design | Page Object Model, Workflow Layer, Reusable Utilities |

## Project Structure

```text
senior-qa-automation-portfolio/
│
├── .github/
│   └── workflows/
│       └── qa-automation-ci.yml
│
├── database-testing/
│   ├── 01-database-setup.sql
│   ├── 02-test-data.sql
│   └── 03-qa-validation-queries.sql
│
├── selenium-java-framework/
│   ├── src/main/java/
│   │   ├── driver/
│   │   │   └── DriverFactory.java
│   │   ├── pages/
│   │   ├── utils/
│   │   └── workflow/
│   │
│   ├── src/test/java/
│   │   ├── apitests/
│   │   ├── databasetests/
│   │   ├── listeners/
│   │   ├── reports/
│   │   ├── retry/
│   │   ├── runners/
│   │   ├── stepdefinition/
│   │   └── tests/
│   │
│   ├── src/test/resources/
│   │   ├── features/
│   │   ├── Data.xlsx
│   │   ├── log4j2.xml
│   │   └── testng.xml
│   │
│   └── pom.xml
│
└── pom.xml
```

## Framework Architecture

The framework separates automation responsibilities into reusable and maintainable layers:

- **Driver Layer** — Manages browser initialization, ThreadLocal WebDriver instances, cross-browser execution, and headless execution in CI.
- **Page Object Layer** — Encapsulates web element locators and page-level interactions using the Page Object Model (POM).
- **Utility Layer** — Provides reusable Selenium operations such as clicking, typing, explicit waits, dropdown handling, and scrolling.
- **Workflow Layer** — Combines multiple page-level actions into reusable business workflows, including the end-to-end insurance quote process.
- **Test Layer** — Contains TestNG-based UI, API, and database validation tests.
- **BDD Layer** — Uses Cucumber feature files and step definitions to represent business-readable end-to-end scenarios.
- **Data Layer** — Provides external Excel-based test data using Apache POI and TestNG DataProvider.
- **Listener & Reporting Layer** — Handles test lifecycle events, Extent Reports generation, failure screenshots, retry handling, and Log4j2 logging.
- **CI/CD Layer** — GitHub Actions provisions Java and MySQL, initializes database test data, executes the Maven test suite, and publishes Extent Reports, Cucumber HTML reports, and failure screenshots as artifacts.

## How to Run the Tests

### Prerequisites

Before running the framework locally, ensure the following are installed:

- Java 17
- Maven
- Google Chrome
- MySQL Server

### Database Setup

The database tests use a local MySQL database named `insurance_db`.

Run the following SQL scripts before executing the complete test suite:

```text
database-testing/01-database-setup.sql
database-testing/02-test-data.sql
```

The database password is supplied through the `DB_PASSWORD` environment variable and is not stored in the source code.

### Run the Complete Test Suite

From the project root directory:

```bash
mvn clean test
```

This executes the automated TestNG suite, including UI automation, API tests, database validations, and Cucumber BDD scenarios.

### Test Results

After execution:

- Extent Report: `selenium-java-framework/reports/ExtentReport.html`
- Cucumber Report: `selenium-java-framework/target/cucumber-report.html`
- Execution logs: `selenium-java-framework/logs/automation.log`
- Failure screenshots: `selenium-java-framework/screenshots/`

Generated reports, logs, and screenshots are excluded from version control.

## Continuous Integration

The project uses GitHub Actions to automatically execute the automation suite on pushes and pull requests to the `main` branch.

The CI pipeline:

1. Checks out the repository.
2. Configures Java 17.
3. Starts a MySQL 8.4 service container.
4. Initializes the insurance test database and test data.
5. Executes the complete Maven automation suite.
6. Uploads failure screenshots when available.
7. Publishes the Extent Report as a GitHub Actions artifact.
8. Publishes the Cucumber HTML report as a GitHub Actions artifact.

Database credentials are securely supplied through GitHub Actions Secrets rather than being stored in the repository.

## Key Test Scenarios

The portfolio demonstrates automation across multiple testing layers:

- End-to-end automobile insurance quote submission using Selenium WebDriver.
- Data-driven UI execution using external Excel test data.
- Business-readable insurance workflow validation using Cucumber BDD.
- REST API validation covering GET, POST, PUT, and DELETE operations.
- MySQL database connectivity and customer data validation using JDBC.
- PreparedStatement-based backend verification.
- Automatic retry handling for failed TestNG tests.
- Automatic screenshot capture when UI tests fail.
- Extent HTML report generation after test execution.
- Structured execution logging using Log4j2.
- Automated execution of UI, API, database, and BDD tests through GitHub Actions.

## CI Status

The complete automation suite has been successfully executed through GitHub Actions with:

```text
Tests run: 10
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```
The latest CI execution validates the complete portfolio suite across UI automation, REST API testing, JDBC/MySQL database testing, and Cucumber BDD.

## Project Purpose

This repository was created to demonstrate the design and implementation of a maintainable QA automation framework covering UI, API, database, and BDD testing with automated CI execution, reporting, logging, test-data management, and failure diagnostics.