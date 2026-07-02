package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void serve() {
        System.out.println("BookService method serve executed.");
        if (bookRepository != null) {
            System.out.print("Dependency injected successfully: ");
            bookRepository.printRepositoryInfo();
        } else {
            System.out.println("Dependency NOT injected.");
        }
    }
}
