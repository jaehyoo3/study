package com.group.libraryapp.Service;

import com.group.libraryapp.Repository.BookRepository;
import com.group.libraryapp.Service.dto.CreateBookDTO;
import com.group.libraryapp.domain.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Transactional
    public void addBook(CreateBookDTO request) {
        bookRepository.save(new Book(request.getName()));
    }
}
