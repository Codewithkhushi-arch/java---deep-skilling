package com.company.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/inventory")
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @GetMapping("/{productId}")
    public Map<String, Object> getInventory(@PathVariable String productId) {
        Map<String, Object> inventory = new HashMap<>();
        inventory.put("productId", productId);
        inventory.put("inStock", true);
        inventory.put("quantity", 42);
        return inventory;
    }
}
