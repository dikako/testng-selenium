# Project Overview (Generate by AI)
This repository is a Gradle-based Java 17 project using a standard src/main and src/test layout. It includes:
- A simple application entry point under src/main/java.
- A UI test suite under src/test with Page Object Model structure, environment-based configuration, and test data/resources.

# Project Structure
- build.gradle
- settings.gradle
- gradle/, gradlew, gradlew.bat
- src/
    - main/
        - java/
            - org/
                - example/
                    - Main.java

        - resources/

    - test/
        - java/
            - dibimbing/
                - core/
                    - BaseTest.java
                    - TestUtils.java
                    - DriverManager.java

                - pages/
                    - BasePage.java
                    - LoginPage.java

                - tests/
                    - LoginTest.java

        - resources/
            - config/
                - staging.properties
                - production.properties

            - suites/
            - testdata/

Notes:
- The test code follows a Page Object structure under dibimbing.pages and uses core utilities and a driver manager under dibimbing.core.
- Environment-specific configs live in src/test/resources/config (e.g., staging.properties, production.properties).
- Test suites and data are organized under src/test/resources/suites and src/test/resources/testdata.

# Requirements
- Java 17
- Gradle (use the included Gradle Wrapper)
- IntelliJ IDEA (recommended) or any Java IDE
- Lombok (annotation processing must be enabled in your IDE)

IntelliJ setup:
- Enable annotation processing: Settings > Build, Execution, Deployment > Compiler > Annotation Processors > Enable annotation processing.
- Ensure Project SDK is set to Java 17.

# Build
Use the Gradle Wrapper:
``` bash
# Clean build
./gradlew clean build
```
Artifacts will be placed under build/.
# Run the Application
If you have a main class (e.g., org.example.Main):
``` bash
./gradlew run --args=""
```
Or run the Main class directly from your IDE.
# Testing
Run all tests:
``` bash
./gradlew clean test
```
Run a single test class:
``` bash
./gradlew test --tests "dibimbing.tests.LoginTest"
```
Run tests matching a method pattern:
``` bash
./gradlew test --tests "dibimbing.tests.LoginTest.someMethodName"
```
HTML test reports:
- Build reports are typically at build/reports/tests/test/index.html.

# Test Configuration
Environment configs are under src/test/resources/config:
- staging.properties
- production.properties

Example usage (conventions vary by your codebase; ensure your test bootstrap reads env system property):
``` bash
# Run tests against staging
./gradlew test -Denv=staging

# Run tests against production
./gradlew test -Denv=production
```
Common property patterns (for reference):
``` properties
# src/test/resources/config/staging.properties
baseUrl=https://staging.example.com
browser=chrome
timeout=30
```
# Project Conventions
- Page Objects: src/test/java/dibimbing/pages
    - Encapsulate UI locators and interactions.

- Test Base/Utilities: src/test/java/dibimbing/core
    - DriverManager: WebDriver lifecycle/configuration
    - BaseTest: common setup/teardown, environment loading
    - TestUtils: shared helpers

- Tests: src/test/java/dibimbing/tests
    - Example: LoginTest.java

# IDE Tips (IntelliJ IDEA)
- Run/Debug any test by right-clicking the test class/method and selecting Run.
- Create a Gradle Run Configuration for test tasks (Run > Edit Configurations > + > Gradle).
- Set VM options (e.g., -Denv=staging) in the Run Configuration to switch environments.

# Linting/Formatting
If you use Lombok and additional code style tools, ensure:
- Lombok plugin is installed and enabled in IntelliJ.
- Annotation processing is on.

# Troubleshooting
- Lombok annotations not recognized:
    - Install Lombok plugin and enable annotation processing.

- WebDriver/init failures:
    - Verify browser drivers and versions.
    - Check environment properties (baseUrl, browser).

- Tests don’t find resources:
    - Ensure files are under src/test/resources and referenced correctly by the classpath.

# How to Extend
- Add a new Page Object:
    - Create a class under src/test/java/dibimbing/pages and expose clear methods for interactions.

- Add a new Test:
    - Create under src/test/java/dibimbing/tests, reuse BaseTest for setup, and use page objects for actions.

- Add environment:
    - Create a new properties file under src/test/resources/config (e.g., qa.properties) and pass -Denv=qa.

# License
Add your license information here.
# Authors
- Sleeper.Inc
