package com.company.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        System.out.println("Running LoggingExample main method...");

        // Exercise 1: Logging Error and Warning Levels
        logger.error("This is a logging ERROR message.");
        logger.warn("This is a logging WARNING message.");

        // Exercise 2: Parameterized Logging
        String username = "JohnDoe";
        String ipAddress = "192.168.1.100";
        int loginAttempts = 3;

        logger.info("User '{}' attempted to log in from IP: {}", username, ipAddress);
        logger.debug("Failed login attempts for '{}': {}", username, loginAttempts);

        System.out.println("Logging complete. Check console output and 'app.log' file.");
    }
}
