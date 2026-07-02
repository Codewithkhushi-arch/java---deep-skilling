# Spring Core, AOP, and Spring Boot Exercises

This repository contains a collection of 9 standalone hands-on exercises demonstrating core concepts of the Spring Framework, Dependency Injection, Aspect-Oriented Programming (AOP), Maven builds, and Spring Boot.

## 🛠️ Technology Stack & Constraints
- **Java Version**: `1.8` (Java 8 compatible)
- **Spring Framework Version**: `5.3.31` (Exercises 1–8)
- **Spring Boot Version**: `2.7.18` (Exercise 9)
- **Database**: H2 In-Memory Database (Exercise 9)
- **ORM/JPA**: Hibernate / Spring Data JPA (Exercise 9)
- **Build Tool**: Apache Maven `3.9.8`

---

## 📂 Project Structure

```text
Spring Core and Maven/
│
├── 01-spring-xml-basic-config/         # Basic Spring Bean configuration using XML
├── 02-spring-setter-injection/         # Spring XML Setter Injection
├── 03-spring-aop-around-logging/       # Logging with Spring AOP (Around Advice)
├── 04-maven-dependency-compiler/       # Maven compiler & multi-dependency configuration
├── 05-spring-ioc-wiring/               # Standard IoC Container & Bean wiring
├── 06-spring-annotation-config/        # Annotation-based configuration (@Service, @Repository, @Autowired)
├── 07-constructor-setter-injection/    # Side-by-side Constructor and Setter Injection
├── 08-spring-aop-before-after/         # Basic AOP Aspects (Before and After Advice)
├── 09-spring-boot-jpa-h2/              # Spring Boot REST API + Spring Data JPA + H2 Database
│
└── README.md                           # Execution outputs & documentation (This file)
```

---

## 🚀 Execution & Verification Outputs

Below are the actual console outputs produced during successful compilation and execution of each exercise using Maven.

### 📝 Exercise 1: Configuring a Basic Spring Application
Loads `applicationContext.xml` to retrieve and run simple `BookService` and `BookRepository` beans.
```text
[INFO] Scanning for projects...
[INFO] --- exec:3.6.3:java (default-cli) @ LibraryManagement ---
BookRepository method printRepositoryInfo executed.
BookService method serve executed.
Exercise 1 configuration loaded and executed successfully!
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
```

---

### 📝 Exercise 2: Implementing Dependency Injection
Wires `BookRepository` into `BookService` using Spring setter injection (`<property>`).
```text
[INFO] --- exec:3.6.3:java (default-cli) @ LibraryManagement ---
BookService method serve executed.
Dependency injected successfully: BookRepository method printRepositoryInfo executed.
Exercise 2 dependency injection verified successfully!
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
```

---

### 📝 Exercise 3: Implementing Logging with Spring AOP
Logs method execution times using an AspectJ AOP interceptor configured in XML.
```text
[INFO] --- exec:3.6.3:java (default-cli) @ LibraryManagement ---
[Aspect Log] Before method execution: BookService.serve()
BookService method serve executed.
BookRepository method printRepositoryInfo executed.
[Aspect Log] After method execution: BookService.serve() executed in 28ms
Exercise 3 logging aspect verified successfully!
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
```

---

### 📝 Exercise 4: Creating and Configuring a Maven Project
Defines dependencies for Context, AOP, and WebMVC, and configures the compilation level.
```text
[INFO] Scanning for projects...
[INFO] --- compiler:3.8.1:compile (default-compile) @ LibraryManagement ---
[INFO] No sources to compile
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
```

---

### 📝 Exercise 5: Configuring the Spring IoC Container
Configures the main container via XML to retrieve the setter-injected service bean.
```text
[INFO] --- exec:3.6.3:java (default-cli) @ LibraryManagement ---
BookService method serve executed.
Dependency injected successfully: BookRepository method printRepositoryInfo executed.
Exercise 5 Spring IoC container loaded and verified successfully!
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
```

---

### 📝 Exercise 6: Configuring Beans with Annotations
Uses component scanning (`<context:component-scan>`) and annotations (`@Service`, `@Repository`, `@Autowired`).
```text
[INFO] --- exec:3.6.3:java (default-cli) @ LibraryManagement ---
BookService (Annotation-configured) method serve executed.
Dependency @Autowired injected successfully: BookRepository (Annotation-configured) method printRepositoryInfo executed.
Exercise 6 annotation-based configuration verified successfully!
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
```

---

### 📝 Exercise 7: Implementing Constructor and Setter Injection
Registers two separate configurations of the service to test both constructor and setter wiring methods.
```text
[INFO] --- exec:3.6.3:java (default-cli) @ LibraryManagement ---
--- Testing Constructor Injection ---
BookService serve() executed using Constructor Injection.
BookRepository method printRepositoryInfo executed.
--- Testing Setter Injection ---
BookService serve() executed using Setter Injection.
BookRepository method printRepositoryInfo executed.
Exercise 7 constructor and setter injection verified successfully!
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
```

---

### 📝 Exercise 8: Implementing Basic AOP with Spring
Registers AOP aspects containing Before (`logBefore`) and After (`logAfter`) advice methods.
```text
[INFO] --- exec:3.6.3:java (default-cli) @ LibraryManagement ---
[Aspect Log] Before advice: Executing method BookService.serve()
BookService serve() executing core business logic...
BookRepository method printRepositoryInfo executed.
[Aspect Log] After advice: Finished executing method BookService.serve()
Exercise 8 basic AOP functionality verified successfully!
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
```

---

### 📝 Exercise 9: Creating a Spring Boot Application
Starts a full REST web service using Spring Boot on port `8080`, exposing `/api/books` endpoints.
```text
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::               (v2.7.18)

INFO 34480 --- [main] c.library.LibraryManagementApplication   : Started LibraryManagementApplication in 5.578 seconds (JVM running for 6.182)
INFO 34480 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
```

#### Automated REST API Verification Output:
```text
Checking if Spring Boot server is ready... (attempt 4/15)
Spring Boot server is running! Starting REST CRUD tests...

--- 1. Testing POST (Create Book) ---
Created: {'id': 1, 'title': 'Spring in Action', 'author': 'Craig Walls'}

--- 2. Testing GET All ---
All Books: [{'id': 1, 'title': 'Spring in Action', 'author': 'Craig Walls'}]

--- 3. Testing PUT (Update Book) ---
Updated: {'id': 1, 'title': 'Spring in Action, 6th Edition', 'author': 'Craig Walls'}

--- 4. Testing GET by ID ---
Book by ID: {'id': 1, 'title': 'Spring in Action, 6th Edition', 'author': 'Craig Walls'}

--- 5. Testing DELETE ---
Delete Response Code: 200

--- 6. Verify Empty after Delete ---
All Books after Delete: []

All Spring Boot REST CRUD tests passed successfully!
```

---

## 🏃 How to Run Locally

1. **Verify/Install Maven**:
   Ensure Apache Maven is installed on your system and configured in your environment PATH.

2. **Run Spring Core Projects (Exercises 1–8)**:
   Navigate to the respective exercise folder and compile/execute:
   ```bash
   cd Exercise1/LibraryManagement
   mvn clean compile exec:java -Dexec.mainClass="com.library.LibraryManagementApplication"
   ```

3. **Run Spring Boot Application (Exercise 9)**:
   Navigate to the `Exercise9` folder:
   ```bash
   cd Exercise9/LibraryManagement
   mvn spring-boot:run
   ```
