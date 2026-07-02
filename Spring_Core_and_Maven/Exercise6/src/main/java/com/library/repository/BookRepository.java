package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void printRepositoryInfo() {
        System.out.println("BookRepository (Annotation-configured) method printRepositoryInfo executed.");
    }
}
