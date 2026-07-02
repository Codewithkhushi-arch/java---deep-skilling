package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the Spring XML application context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve and test BookService bean
        BookService service = (BookService) context.getBean("bookService");
        service.serve();

        System.out.println("Exercise 5 Spring IoC container loaded and verified successfully!");
    }
}
