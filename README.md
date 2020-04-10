# helloFreshTests
Simple Automation Test suite using Selenium JVM and TestNG

## Features:
- Logging using log4j2 in console and file.
- Taking a screenshot on failed tests.
- Human readable report using ExtentReports.
- Simple WebDriver factory.
- Encapsulation layers:
  - Test Data using TestNG Data providers.
  - Test Data generated using Java Faker API at run time.
  - Page Objects (without using any framework)
  - DOM locators encapsulated in Page classes.
  - Base URL of target app is encapsulated in `config.properties`
- Ability to run the tests in parallel.
- Support for different browsers. (Firefox and Chrome supported)

## How to run

### Pre-Requisites
1. JDK 8+ is installed and Environment variables are set
2. Maven is installed and Environment variable is set 
3. Clone this repository

### From IDE
- Locate `testng.xml` in project root, right click and select Run
- Browser can be configured by changing `value` following line in the xml file:
`<parameter name="browser" value="chrome"/>`
- Tests can be added or removed from execution by adding and removing `<class>` entry.


### From Command Line

#### Run all tests (Parallel, default: Chrome)
Open Terminal in project root and run:
`mvn clean test -DxmlFileName=testng.xml`
 
#### Run all tests (Parallel, Firefox)
Open Terminal in project root and run:
`mvn clean test -DxmlFileName=testng.xml -Dbrowser=firefox`
 
#### Run single test with specific browser
For example, if you need to run test method "userRegistrationTest" in "AuthenticationTests" class:
Open Terminal in project root and run:
`mvn clean test -DxmlFileName=testng.xml -Dbrowser=firefox -Dtest=AuthenticationTests#userRegistrationTest`

#### Run all tests in single class with specific browser (Parallel)
For example, if you need to run test methods in "AuthenticationTests" class:
Open Terminal in project root and run:
`mvn clean test -DxmlFileName=testng.xml -Dbrowser=firefox -Dtest=AuthenticationTests`

### Where to find Test Report?
Test HTML report is generated at the end of each run inside TestReport folder in project root.

### Where to find failed test screenshots?
Screenshots in case of failure saved as .png file inside FailureScreenshots folder in project root.

### Where to find logs after test run?
Logs are populated for each run inside logs folder in project root.


#### Known limitations:
- Extent report does not generate if a subset of tests are run using `mvn test` commands.
