package com.cognizant.ormlearn;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.model.AttemptOption;
import com.cognizant.ormlearn.model.AttemptQuestion;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Option;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.AttemptService;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.StockService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;
    private static StockService stockService;
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;
    private static AttemptService attemptService;

    @Autowired
    public void setCountryService(CountryService countryService) {
        OrmLearnApplication.countryService = countryService;
    }

    @Autowired
    public void setStockService(StockService stockService) {
        OrmLearnApplication.stockService = stockService;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        OrmLearnApplication.employeeService = employeeService;
    }

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        OrmLearnApplication.departmentService = departmentService;
    }

    @Autowired
    public void setSkillService(SkillService skillService) {
        OrmLearnApplication.skillService = skillService;
    }

    @Autowired
    public void setAttemptService(AttemptService attemptService) {
        OrmLearnApplication.attemptService = attemptService;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n\n=======================================================");
        System.out.println("  STARTING ORM-LEARN HANDS-ON RUNNER (RECRUITER REVIEW)  ");
        System.out.println("=======================================================\n");

        runCountryHandsOnTests();
        runStockHandsOnTests();
        runPayrollRelationshipTests();
        runHqlAndNativeQueryTests();
        runQuizAttemptTests();

        System.out.println("\n=======================================================");
        System.out.println("  ALL ORM-LEARN HANDS-ON TESTS COMPLETED SUCCESSFULLY  ");
        System.out.println("=======================================================\n\n");
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End");
    }

    private static void getAllCountriesTest() {
        LOGGER.info("Start");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country:{}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Exception: {}", e.getMessage());
        }
        LOGGER.info("End");
    }

    private static void testAddCountry() {
        LOGGER.info("Start");
        Country newCountry = new Country("XX", "Test Country");
        countryService.addCountry(newCountry);
        try {
            Country retrieved = countryService.findCountryByCode("XX");
            LOGGER.debug("Added Country:{}", retrieved);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Failed to add country: {}", e.getMessage());
        }
        LOGGER.info("End");
    }

    private static void testUpdateCountry() {
        LOGGER.info("Start");
        try {
            countryService.updateCountry("XX", "Updated Test Country");
            Country retrieved = countryService.findCountryByCode("XX");
            LOGGER.debug("Updated Country Name:{}", retrieved.getName());
        } catch (CountryNotFoundException e) {
            LOGGER.error("Failed to update country: {}", e.getMessage());
        }
        LOGGER.info("End");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start");
        countryService.deleteCountry("XX");
        try {
            countryService.findCountryByCode("XX");
            LOGGER.error("Error: Country 'XX' was not deleted!");
        } catch (CountryNotFoundException e) {
            LOGGER.debug("Successfully verified deletion of country 'XX' (threw CountryNotFoundException).");
        }
        LOGGER.info("End");
    }

    private static void testGetEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee:{}", employee);
        LOGGER.debug("Department:{}", employee.getDepartment());
        LOGGER.info("End");
    }

    private static void testAddEmployee() {
        LOGGER.info("Start");
        Employee newEmp = new Employee();
        newEmp.setName("Recruiter Test");
        newEmp.setSalary(7500.00);
        newEmp.setPermanent(true);
        newEmp.setDateOfBirth(new Date());
        newEmp.setDepartment(departmentService.get(1)); // HR
        employeeService.save(newEmp);
        LOGGER.debug("Saved employee:{}", newEmp);
        LOGGER.info("End");
    }

    private static void testUpdateEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1);
        employee.setDepartment(departmentService.get(2)); // Payroll
        employeeService.save(employee);
        LOGGER.debug("Updated Employee:{}", employee);
        LOGGER.info("End");
    }

    public static void testGetAllPermanentEmployees() {
        LOGGER.info("Start");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees:{}", employees);
        employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
        LOGGER.info("End");
    }

    private void runCountryHandsOnTests() {
        System.out.println("-------------------------------------------------------");
        System.out.println("[Hands On 1] Retrieve All Countries");
        System.out.println("-------------------------------------------------------");
        testGetAllCountries();

        System.out.println("\n-------------------------------------------------------");
        System.out.println("[Hands On 6] Find Country by Code");
        System.out.println("-------------------------------------------------------");
        getAllCountriesTest();

        System.out.println("\n-------------------------------------------------------");
        System.out.println("[Hands On 7] Add New Country");
        System.out.println("-------------------------------------------------------");
        testAddCountry();

        System.out.println("\n-------------------------------------------------------");
        System.out.println("[Hands On 8] Update Country Name");
        System.out.println("-------------------------------------------------------");
        testUpdateCountry();

        System.out.println("\n-------------------------------------------------------");
        System.out.println("[Hands On 9] Delete Country");
        System.out.println("-------------------------------------------------------");
        testDeleteCountry();

        System.out.println("\n-------------------------------------------------------");
        System.out.println("[Doc 2 Hands On 1] Query Methods on Country Table");
        System.out.println("-------------------------------------------------------");
        System.out.println("Countries containing 'ou':");
        countryService.findCountriesByNameContaining("ou")
                .forEach(c -> System.out.println("  " + c.getCode() + "  " + c.getName()));

        System.out.println("\nCountries containing 'ou' sorted by Name Ascending:");
        countryService.findCountriesByNameContainingOrderByNameAsc("ou")
                .forEach(c -> System.out.println("  " + c.getCode() + "  " + c.getName()));

        System.out.println("\nCountries starting with 'Z':");
        countryService.findCountriesByNameStartingWith("Z")
                .forEach(c -> System.out.println("  " + c.getCode() + "  " + c.getName()));
    }

    private void runStockHandsOnTests() {
        System.out.println("\n-------------------------------------------------------");
        System.out.println("[Doc 2 Hands On 2] Stock Table Queries");
        System.out.println("-------------------------------------------------------");
        System.out.println("Facebook stock details in September 2019:");
        List<Stock> fbStocks = stockService.getFacebookStocksInSeptember2019();
        fbStocks.forEach(s -> System.out.printf("  %s | %s | %.2f | %.2f | %d\n",
                s.getCode(), s.getDate(), s.getOpen(), s.getClose(), s.getVolume()));

        System.out.println("\nGoogle stock details where close price > 1250:");
        List<Stock> googleStocks = stockService.getGoogleStocksGreaterThan1250();
        googleStocks.forEach(s -> System.out.printf("  %s | %s | %.2f | %.2f | %d\n",
                s.getCode(), s.getDate(), s.getOpen(), s.getClose(), s.getVolume()));

        System.out.println("\nTop 3 dates with highest volume of transactions:");
        List<Stock> highestVol = stockService.getTop3HighestVolumeStocks();
        highestVol.forEach(s -> System.out.printf("  %s | %s | %.2f | %.2f | %d\n",
                s.getCode(), s.getDate(), s.getOpen(), s.getClose(), s.getVolume()));

        System.out.println("\nTop 3 dates when Netflix stocks were the lowest:");
        List<Stock> lowestNflx = stockService.getLowest3NetflixStocks();
        lowestNflx.forEach(s -> System.out.printf("  %s | %s | %.2f | %.2f | %d\n",
                s.getCode(), s.getDate(), s.getOpen(), s.getClose(), s.getVolume()));
    }

    private void runPayrollRelationshipTests() {
        System.out.println("\n-------------------------------------------------------");
        System.out.println("[Doc 2 Hands On 4] Many-to-One: Employee and Department");
        System.out.println("-------------------------------------------------------");
        testGetEmployee();

        System.out.println("\nAdding a new employee...");
        testAddEmployee();

        System.out.println("\nUpdating employee department...");
        testUpdateEmployee();

        System.out.println("\n-------------------------------------------------------");
        System.out.println("[Doc 2 Hands On 5] One-to-Many: Department and Employee");
        System.out.println("-------------------------------------------------------");
        Department dept = departmentService.get(2);
        System.out.println("Department: " + dept.getName());
        System.out.println("Employees in department:");
        dept.getEmployeeList().forEach(e -> System.out.println("  - " + e.getName()));

        System.out.println("\n-------------------------------------------------------");
        System.out.println("[Doc 2 Hands On 6] Many-to-Many: Employee and Skill");
        System.out.println("-------------------------------------------------------");
        Employee empWithSkills = employeeService.get(1);
        System.out.println("Employee: " + empWithSkills.getName());
        System.out.println("Skills: ");
        empWithSkills.getSkillList().forEach(s -> System.out.println("  - " + s.getName()));

        System.out.println("\nAdding a new skill to Employee 1...");
        Skill newSkill = skillService.get(3); // SQL
        empWithSkills.getSkillList().add(newSkill);
        employeeService.save(empWithSkills);
        Employee updatedEmp = employeeService.get(1);
        System.out.println("Verified skills of Employee 1 after saving: ");
        updatedEmp.getSkillList().forEach(s -> System.out.println("  - " + s.getName()));
    }

    private void runHqlAndNativeQueryTests() {
        System.out.println("\n-------------------------------------------------------");
        System.out.println("[Doc 3 Hands On 2] HQL Query permanent employees");
        System.out.println("-------------------------------------------------------");
        testGetAllPermanentEmployees();

        System.out.println("\n-------------------------------------------------------");
        System.out.println("[Doc 3 Hands On 4] HQL average salary of a department");
        System.out.println("-------------------------------------------------------");
        double avgSalary = employeeService.getAverageSalary(2);
        System.out.printf("Average salary of Department 2: %.2f\n", avgSalary);

        System.out.println("\n-------------------------------------------------------");
        System.out.println("[Doc 3 Hands On 5] Native Query: Get All Employees");
        System.out.println("-------------------------------------------------------");
        List<Employee> allEmployees = employeeService.getAllEmployeesNative();
        System.out.println("All employees retrieved via Native Query: " + allEmployees.size());
        allEmployees.forEach(e -> System.out.println("  - " + e.getName()));
    }

    private void runQuizAttemptTests() {
        System.out.println("\n-------------------------------------------------------");
        System.out.println("[Doc 3 Hands On 3] Quiz Attempt Details using HQL");
        System.out.println("-------------------------------------------------------");
        Attempt attempt = attemptService.getAttempt(1, 1);
        if (attempt != null) {
            System.out.println("User: " + attempt.getUser().getName());
            System.out.println("Attempt Date: " + attempt.getDate());
            System.out.println();

            for (AttemptQuestion aq : attempt.getAttemptQuestions()) {
                System.out.println(aq.getQuestion().getText());
                
                // Get options sorted by ID for consistent display
                Set<Option> options = aq.getQuestion().getOptions();
                int optNum = 1;
                for (Option opt : options) {
                    // Check if this option was selected
                    boolean isSelected = false;
                    for (AttemptOption ao : aq.getAttemptOptions()) {
                        if (ao.getOption().getId() == opt.getId() && ao.isSelected()) {
                            isSelected = true;
                            break;
                        }
                    }
                    System.out.printf("  %d) %-10s   %.1f    %b\n", 
                        optNum++, opt.getText(), opt.getScore(), isSelected);
                }
                System.out.println();
            }
        } else {
            System.err.println("Attempt not found!");
        }
    }
}
