package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the Spring XML application context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve and verify Constructor Injection bean
        System.out.println("--- Testing Constructor Injection ---");
        BookService constructorService = (BookService) context.getBean("bookServiceConstructor");
        constructorService.serve();

        // Retrieve and verify Setter Injection bean
        System.out.println("--- Testing Setter Injection ---");
        BookService setterService = (BookService) context.getBean("bookServiceSetter");
        setterService.serve();

        System.out.println("Exercise 7 constructor and setter injection verified successfully!");
    }
}
