package com.cognizant.springlearn.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
    private List<Country> countries;

    @SuppressWarnings("unchecked")
    public CountryService() {
        LOGGER.info("START CountryService Constructor");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        this.countries = context.getBean("countryList", List.class);
        LOGGER.info("END CountryService Constructor");
    }

    public List<Country> getAllCountries() {
        LOGGER.info("START getAllCountries");
        LOGGER.info("END getAllCountries");
        return countries;
    }

    public Country getCountry(String code) throws CountryNotFoundException {
        LOGGER.info("START getCountry: {}", code);
        Country country = countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new CountryNotFoundException("Country not found"));
        LOGGER.debug("Found Country: {}", country);
        LOGGER.info("END getCountry");
        return country;
    }
}
