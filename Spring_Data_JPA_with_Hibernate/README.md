# Spring Data JPA with Hibernate Hands-On & Exercises

This folder contains complete, verified implementations of the Spring Data JPA and Hibernate hands-on tasks and exercises.

## Projects Included

### 1. `orm-learn`
Implements the hands-on exercises from the three documents:
- **`1. spring-data-jpa-handson.docx`**: JPA/Hibernate core concepts, basic DML operations on single tables, H2 database connection configuration, and custom repositories (`CountryRepository` & `CountryService`).
- **`2. spring-data-jpa-handson.docx`**: Derived query methods (stock market search filtering), entity mappings for relationships (One-to-Many, Many-to-One, Many-to-Many).
- **`3. spring-data-jpa-handson.docx`**: Hibernate Query Language (HQL) join optimizations using `left join fetch`, native SQL queries, and retrieving complex quiz attempt graphs in a single query.

### 2. `EmployeeManagementSystem`
Implements all 10 exercises from:
- **`Spring Data JPA and Hibernate.docx`**:
  - *Exercise 1 & 2*: Project setup, H2 datasource configuration, Employee/Department entity mapping.
  - *Exercise 3 & 4*: Repository and RESTful controller mapping for full CRUD endpoints.
  - *Exercise 5*: Derived query methods, `@Query` annotations, and custom Named Queries (`@NamedQuery`).
  - *Exercise 6*: Pageable & Sortable search queries combining both filters.
  - *Exercise 7*: Entity auditing via `@EnableJpaAuditing` and `@CreatedBy`, `@CreatedDate`, etc.
  - *Exercise 8*: Class-based and interface-based closed/dynamic SpEL projections.
  - *Exercise 9*: Custom data source configuration (Multiple data sources: primary database for employee tables, secondary database for logs/audits).
  - *Exercise 10*: Hibernate batch processing parameters for insert/update queries.

---

## Zero-Setup Recruiter Run Guide

To make evaluation simple and setup-free, both projects run on **H2 in-memory databases** and seed automatically.

### Windows (One-Click Runner)
1. Double-click the **`run_all.bat`** file in the root folder.
2. The script will:
   - Check your local Java installation (supports Java 8+).
   - Build and run the `orm-learn` console test suite.
   - Build and run the `EmployeeManagementSystem` web application (port 8080).
3. The console will print formatted reports proving every single hands-on task and exercise runs and executes successfully.

### Manual Command Line (Windows/Linux/macOS)
Make sure you run these from the root directory:

**To run the `orm-learn` tests:**
```bash
cd orm-learn
../maven/apache-maven-3.9.8/bin/mvn.cmd clean package -DskipTests
java -jar target/orm-learn-0.0.1-SNAPSHOT.jar
```

**To run the `EmployeeManagementSystem` REST APIs:**
```bash
cd EmployeeManagementSystem
../maven/apache-maven-3.9.8/bin/mvn.cmd clean package -DskipTests
java -jar target/EmployeeManagementSystem-0.0.1-SNAPSHOT.jar
```
*(Once started, you can access the H2 console at `http://localhost:8080/h2-console`)*

---

## Code Base Mapping Reference

- **Country Service CRUD & Searches**: See [CountryService.java](file:///c:/Users/KHUSHI/Downloads/java%20skilling/Spring%20Data%20JPA%20with%20Hibernate/orm-learn/src/main/java/com/cognizant/ormlearn/service/CountryService.java).
- **Yahoo Stock market searches**: See [StockRepository.java](file:///c:/Users/KHUSHI/Downloads/java%20skilling/Spring%20Data%20JPA%20with%20Hibernate/orm-learn/src/main/java/com/cognizant/ormlearn/repository/StockRepository.java).
- **Payroll Relationship Mapping**: See [Employee.java](file:///c:/Users/KHUSHI/Downloads/java%20skilling/Spring%20Data%20JPA%20with%20Hibernate/orm-learn/src/main/java/com/cognizant/ormlearn/model/Employee.java) and [Department.java](file:///c:/Users/KHUSHI/Downloads/java%20skilling/Spring%20Data%20JPA%20with%20Hibernate/orm-learn/src/main/java/com/cognizant/ormlearn/model/Department.java).
- **Quiz Attempts Optimized HQL Query**: See [AttemptRepository.java](file:///c:/Users/KHUSHI/Downloads/java%20skilling/Spring%20Data%20JPA%20with%20Hibernate/orm-learn/src/main/java/com/cognizant/ormlearn/repository/AttemptRepository.java).
- **Multiple Datasources configuration**: See [PrimaryDbConfig.java](file:///c:/Users/KHUSHI/Downloads/java%20skilling/Spring%20Data%20JPA%20with%20Hibernate/EmployeeManagementSystem/src/main/java/com/employeemanagement/config/PrimaryDbConfig.java) and [SecondaryDbConfig.java](file:///c:/Users/KHUSHI/Downloads/java%20skilling/Spring%20Data%20JPA%20with%20Hibernate/EmployeeManagementSystem/src/main/java/com/employeemanagement/config/SecondaryDbConfig.java).
- **JPA Auditing configuration**: See [AuditingConfig.java](file:///c:/Users/KHUSHI/Downloads/java%20skilling/Spring%20Data%20JPA%20with%20Hibernate/EmployeeManagementSystem/src/main/java/com/employeemanagement/config/AuditingConfig.java).
- **Dynamic SpEL Projections**: See [EmployeeDtoInterface.java](file:///c:/Users/KHUSHI/Downloads/java%20skilling/Spring%20Data%20JPA%20with%20Hibernate/EmployeeManagementSystem/src/main/java/com/employeemanagement/dto/EmployeeDtoInterface.java).
