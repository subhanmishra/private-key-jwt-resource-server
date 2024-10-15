package com.subhanmishra.resourceserver.service;


import com.subhanmishra.resourceserver.dto.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    @PostConstruct
    private void init() {
        books.add(new Book(1, "Reactive Spring"));
        books.add(new Book(2, "Spring Boot Up & Running"));
        books.add(new Book(3, "Spring Cloud in Action"));
    }

    public List<Book> findAll() {
        return books;
    }

    public Book findBookByName(Integer id) {
        return books.stream()
                .filter(book -> id.intValue() == book.id().intValue())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

}
