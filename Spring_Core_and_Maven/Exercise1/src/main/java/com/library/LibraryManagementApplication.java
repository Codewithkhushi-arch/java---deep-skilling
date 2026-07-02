package com.library;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;
import com.library.repository.BookRepository;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the Spring XML application context in try-with-resources to prevent resource leaks
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            // Retrieve and test BookRepository bean
            BookRepository repository = (BookRepository) context.getBean("bookRepository");
            repository.printRepositoryInfo();

            // Retrieve and test BookService bean
            BookService service = (BookService) context.getBean("bookService");
            service.serve();

            System.out.println("Exercise 1 configuration loaded and executed successfully!");
        }
    }
}
