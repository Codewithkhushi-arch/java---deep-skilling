package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the Spring XML application context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve and test BookService bean
        BookService service = context.getBean(BookService.class);
        service.serve();

        System.out.println("Exercise 6 annotation-based configuration verified successfully!");
    }
}
