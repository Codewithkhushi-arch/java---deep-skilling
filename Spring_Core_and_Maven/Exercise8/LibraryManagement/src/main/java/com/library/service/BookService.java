package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void serve() {
        System.out.println("BookService serve() executing core business logic...");
        if (bookRepository != null) {
            bookRepository.printRepositoryInfo();
        }
    }
}
