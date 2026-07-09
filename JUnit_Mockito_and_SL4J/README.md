# JUnit, Mockito, and SLF4J Coding Exercises & Portfolio

This repository contains a comprehensive set of 7 Java projects demonstrating testing and logging best practices, designed to showcase expert proficiency in **JUnit 5**, **Mockito**, and **SLF4J/Logback** logging configuration. 

These projects conform to enterprise-grade Java coding standards and demonstrate how to write clean, maintainable, and robust unit, integration, and performance tests for Java and Spring Boot applications.

---

## 📂 Projects Directory

### 1. [junit-basic-exercises](./junit-basic-exercises)
- **Concepts Showcased**: Basic testing setup, test lifecycle methods (`@BeforeEach`, `@AfterEach`), standard assertions, and the Arrange-Act-Assert (AAA) pattern.
- **Classes**: `SimpleCalculator`, `SimpleCalculatorTest`, `AssertionsTest`, `CalculatorTest`.
- **Test Output Summary**: 8 tests run and passed successfully.

### 2. [junit-advanced-exercises](./junit-advanced-exercises)
- **Concepts Showcased**: Parameterized tests using `@ParameterizedTest` & `@ValueSource`, exception testing with `assertThrows`, timeout & performance testing with `assertTimeoutPreemptively`, test suites using `@Suite` and `@SelectClasses`, and test execution ordering using `@TestMethodOrder`.
- **Classes**: `EvenChecker`, `ExceptionThrower`, `PerformanceTester`, and their respective test classes.
- **Test Output Summary**: 30 tests run and passed successfully (including suite runs).

### 3. [mockito-basic-exercises](./mockito-basic-exercises)
- **Concepts Showcased**: Unit testing with mock objects, stubbing methods (`when().thenReturn()`), verifying interactions (`verify()`), argument matching (`anyString()`), testing void methods (`doThrow()`, `doNothing()`), stubbing consecutive calls for multiple returns, and verifying call sequence order using `InOrder`.
- **Classes**: `ExternalApi`, `MyService`, `MyServiceTest`.
- **Test Output Summary**: 7 tests run and passed successfully.

### 4. [mockito-advanced-exercises](./mockito-advanced-exercises)
- **Concepts Showcased**: Mocking database repositories, mocking RESTful APIs (`RestClient`), mocking File I/O interfaces, mocking network connections, and simulating complex consecutive stubbing returns.
- **Classes**: `Repository`, `Service`, `RestClient`, `ApiService`, `FileReader`, `FileWriter`, `FileService`, `NetworkClient`, `NetworkService`, and respective test classes.
- **Test Output Summary**: 5 tests run and passed successfully.

### 5. [junit-spring-test-exercises](./junit-spring-test-exercises)
- **Concepts Showcased**: Spring Boot testing, `@MockBean` service layer mocking, `MockMvc` for controller unit testing, database JPA tests using `@DataJpaTest` and H2 in-memory DB, `@ControllerAdvice` global exception mapping validation, and full integration testing using `@SpringBootTest`.
- **Classes**: `Application`, `CalculatorService`, `User`, `UserRepository`, `UserService`, `UserController`, `GlobalExceptionHandler`, and respective test classes.
- **Test Output Summary**: 12 tests run and passed successfully.

### 6. [mockito-mock-dependencies-exercises](./mockito-mock-dependencies-exercises)
- **Concepts Showcased**: Deep-dive Spring integration with Mockito: controller-level unit tests mocking service beans via `@WebMvcTest` and `@MockBean`, service unit tests using `@ExtendWith(MockitoExtension.class)`, and integration tests with mocked service layers.
- **Classes**: `Application`, `User`, `UserRepository`, `UserService`, `UserController`, and respective test classes.
- **Test Output Summary**: 3 tests run and passed successfully.

### 7. [slf4j-logging-exercises](./slf4j-logging-exercises)
- **Concepts Showcased**: Logging using SLF4J facade, Logback implementation, error and warning level logging, parameterized logging (`logger.info("User {} logged in", username)`), console and file appenders configuration in `logback.xml` writing to `app.log`.
- **Classes**: `LoggingExample`, `logback.xml`.
- **Execution Summary**: Generates clean logs in both console and file format.

---

## ⚡ Verifiable Test Run Outputs

Below are the Maven execution logs verifying the correctness and completeness of all implemented tests:

### Projects 1-6 Maven Test Results
```bash
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.company.junitbasic.SimpleCalculatorTest
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.033 s
Running com.company.junitbasic.CalculatorTest
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.013 s
Running com.company.junitbasic.AssertionsTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.059 s
...
Running com.company.junitadvanced.EvenCheckerTest
Tests run: 10, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.113 s
Running com.company.junitadvanced.ExceptionThrowerTest
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.026 s
Running com.company.junitadvanced.OrderedTests
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.006 s
Running com.company.junitadvanced.PerformanceTesterTest
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.136 s
...
Running com.company.mockitobasic.MyServiceTest
Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.845 s
...
Running com.company.mockitoadvanced.ApiServiceTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.113 s
...
Running com.company.springtest.service.ParameterizedSpringTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 2.277 s
Running com.company.springtest.integration.UserIntegrationTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 7.366 s

BUILD SUCCESS (All tests passed)
```

### Project 7 Logback Appenders Logging Output
```bash
Running LoggingExample main method...
16:53:45.244 [com.company.logging.LoggingExample.main()] ERROR com.company.logging.LoggingExample - This is a logging ERROR message.
16:53:45.246 [com.company.logging.LoggingExample.main()] WARN  com.company.logging.LoggingExample - This is a logging WARNING message.
16:53:45.246 [com.company.logging.LoggingExample.main()] INFO  com.company.logging.LoggingExample - User 'JohnDoe' attempted to log in from IP: 192.168.1.100
16:53:45.248 [com.company.logging.LoggingExample.main()] DEBUG com.company.logging.LoggingExample - Failed login attempts for 'JohnDoe': 3
Logging complete. Check console output and 'app.log' file.
```

---

## 🛠️ How to Run Locally

### Prerequisites
- **Java JDK 1.8**
- **Apache Maven 3.x**

### Steps
1. Clone the repository.
2. Navigate to any exercise folder, e.g., `junit-basic-exercises`.
3. Run standard maven test lifecycle:
   ```bash
   mvn clean test
   ```
4. For logging exercises, run:
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.company.logging.LoggingExample"
   ```
