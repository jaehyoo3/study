package com.group.libraryapp.Controller;

import com.group.libraryapp.Service.BookService;
import com.group.libraryapp.Service.dto.CreateBookDTO;
import com.group.libraryapp.Service.dto.LoanBookDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void addBook(@RequestBody CreateBookDTO request) {
        bookService.addBook(request);
    }
    @PostMapping("/loan")
    public void loanBook(@RequestBody LoanBookDTO request) {
        bookService.loanBook(request);
    }
    @PutMapping("/return")
    public void returnBook(@RequestBody LoanBookDTO request) {
        bookService.returnBook(request);
    }
}

