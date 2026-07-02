# Spring RESTful Web Services - Hands-on Exercises

This folder contains a step-by-step implementation of Spring Boot RESTful Web Services, structured across 5 sequential exercise projects. The architecture progresses from basic Spring XML configuration integration up to a stateless, JWT-authenticated RESTful API.

All projects are fully self-contained, target **Spring Boot 2.7.18**, and are compiled and verified on **Java 1.8**.

---

## Repository Structure

```
Spring_REST_using_Spring_Boot/
│
├── 01-spring-boot-core/               # Spring Boot Basics & Spring XML Core Configuration
│   ├── pom.xml                        # Web, DevTools dependencies
│   ├── src/                           # displayDate, displayCountry and scopes demonstration
│   └── build-and-test.log             # Compilation & execution proof logs
│
├── 02-spring-rest-basics/             # REST Controller Basics & MockMvc Testing
│   ├── pom.xml                        # Added Web MVC
│   ├── src/                           # sayHello, getCountry, getCountry/{code} APIs with exceptions
│   └── build-and-test.log             # MockMvc test suite logs (verifying code/name)
│
├── 03-spring-layered-crud/            # Layered Architecture (Controller -> Service -> DAO)
│   ├── pom.xml                        # Transactional annotation support added
│   ├── src/                           # Static Employee & Department list parsing from XML
│   └── build-and-test.log             # Context parsing & API loading logs
│
├── 04-rest-validation-exceptions/     # Validation Constraints & Global Exception Interception
│   ├── pom.xml                        # Added Spring Boot validation starters
│   ├── src/                           # GlobalExceptionHandler mapping validation & format errors
│   └── build-and-test.log             # Exception validation logs
│
└── 05-spring-security-jwt/            # Security & Stateless JWT Authentication
    ├── pom.xml                        # Added Spring Security and JJWT 0.9.0 dependencies
    ├── src/                           # SecurityConfig, JwtAuthorizationFilter & AuthenticationController
    └── build-and-test.log             # Stateless Bearer token verification logs
```

---

## Technical Highlights

### 1. Architectural Patterns
* **Stateless REST Guidelines**: URLs adhere strictly to standard REST conventions using plural resource names (e.g. `/employees`, `/countries/{code}`).
* **Layered Separation**: Direct delegation through `Controller` -> `Service` (with transactional boundaries) -> `DAO` (holding localized static lists parsed from Spring configuration metadata).

### 2. Validation & Custom Interception
* **Hibernate Validator Constraints**: Fields are annotated with `@NotNull`, `@NotBlank`, `@Size`, and `@Min`.
* **Global Interception**: Extends `ResponseEntityExceptionHandler` with `@ControllerAdvice` to format constraint violations (`MethodArgumentNotValidException`) and invalid payload data types (`HttpMessageNotReadableException`) into uniform, client-friendly JSON.

### 3. JWT Authentication Security
* **Access Roles Configuration**: Preconfigured roles `USER` and `ADMIN` with custom BCrypt encrypted passwords.
* **Basic & JWT Handshakes**: Exchange basic credentials at `/authenticate` to receive a signed, stateless JSON Web Token.
* **Filter Pipeline Integration**: Integrates a custom stateless `JwtAuthorizationFilter` (subclass of `BasicAuthenticationFilter`) to authorize subsequent bearer tokens on each API call.

---

## How to Run & Verify

### Running the Applications
Inside any exercise directory (e.g. `05-spring-security-jwt`), run:
```bash
mvn spring-boot:run
```
The server will start locally on port **`8090`** (preconfigured in `application.properties`).

### Executing Tests
To verify test suites and check the MockMvc assertions:
```bash
mvn clean test
```
*(Complete test logs are saved as `build-and-test.log` in each respective exercise directory).*
