package com.company.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @GetMapping("/accounts/{number}")
    public Map<String, Object> getAccountDetails(@PathVariable String number) {
        Map<String, Object> details = new HashMap<>();
        details.put("number", number);
        details.put("type", "savings");
        details.put("balance", 234343);
        return details;
    }
}
