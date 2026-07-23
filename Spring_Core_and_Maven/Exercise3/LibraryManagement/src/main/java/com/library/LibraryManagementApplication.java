package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the Spring XML application context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve and test BookService bean (which is auto-proxied for LoggingAspect)
        BookService service = (BookService) context.getBean("bookService");
        service.serve();

        System.out.println("Exercise 3 logging aspect verified successfully!");
    }
}
