package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void serve() {
        System.out.println("BookService (Annotation-configured) method serve executed.");
        if (bookRepository != null) {
            System.out.print("Dependency @Autowired injected successfully: ");
            bookRepository.printRepositoryInfo();
        } else {
            System.out.println("Dependency NOT @Autowired injected.");
        }
    }
}
