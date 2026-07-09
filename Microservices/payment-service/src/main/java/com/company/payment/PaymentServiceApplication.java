package com.company.payment;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/payment")
public class PaymentServiceApplication {

    private static final Logger logger = LoggerFactory.getLogger(PaymentServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }

    @GetMapping("/process")
    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallbackPayment")
    public String processPayment(@RequestParam(value = "fail", defaultValue = "false") boolean fail) {
        logger.info("Received request to process payment, fail={}", fail);
        if (fail) {
            logger.warn("Simulating internal dependency failure...");
            throw new RuntimeException("Slow third-party API error!");
        }
        return "Payment processed successfully!";
    }

    public String fallbackPayment(boolean fail, Throwable t) {
        logger.warn("Circuit Breaker triggered fallback due to: {}", t.getMessage());
        return "Fallback response: Payment processing is currently delayed. Please try again later.";
    }
}
