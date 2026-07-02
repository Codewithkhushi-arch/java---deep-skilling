package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    private String injectionType;

    // Default constructor for setter injection
    public BookService() {
    }

    // Constructor for constructor injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.injectionType = "Constructor Injection";
    }

    // Setter for setter injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.injectionType = "Setter Injection";
    }

    public void serve() {
        System.out.println("BookService serve() executed using " + injectionType + ".");
        if (bookRepository != null) {
            bookRepository.printRepositoryInfo();
        } else {
            System.out.println("BookRepository is null.");
        }
    }
}
