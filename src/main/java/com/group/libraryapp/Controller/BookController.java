package com.group.libraryapp.Controller;

import com.group.libraryapp.Service.BookService;
import com.group.libraryapp.Service.dto.CreateBookDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public void addBook(@RequestBody CreateBookDTO request) {
        bookService.addBook(request);
    }
}

