package com.cognizant.springlearn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START main");
        SpringApplication.run(SpringLearnApplication.class, args);
        displayDate();
        displayCountry();
        displayCountries();
        LOGGER.info("END main");
    }

    public static void displayDate() {
        LOGGER.info("START displayDate");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml")) {
            SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
            try {
                Date date = format.parse("31/12/2018");
                LOGGER.debug("Parsed Date: {}", date);
            } catch (Exception e) {
                LOGGER.error("Error parsing date: ", e);
            }
        }
        LOGGER.info("END displayDate");
    }

    public static void displayCountry() {
        LOGGER.info("START displayCountry");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml")) {
            Country country = context.getBean("country", Country.class);
            Country anotherCountry = context.getBean("country", Country.class);
            LOGGER.debug("Country : {}", country.toString());
            LOGGER.debug("Another Country : {}", anotherCountry.toString());
        }
        LOGGER.info("END displayCountry");
    }

    @SuppressWarnings("unchecked")
    public static void displayCountries() {
        LOGGER.info("START displayCountries");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml")) {
            List<Country> countries = context.getBean("countryList", List.class);
            LOGGER.debug("Countries : {}", countries);
        }
        LOGGER.info("END displayCountries");
    }
}
