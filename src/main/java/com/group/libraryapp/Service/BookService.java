package com.group.libraryapp.Service;

import com.group.libraryapp.Repository.BookRepository;
import com.group.libraryapp.Repository.UserLoanHistoryRepository;
import com.group.libraryapp.Repository.UserRepository;
import com.group.libraryapp.Service.dto.CreateBookDTO;
import com.group.libraryapp.Service.dto.LoanBookDTO;
import com.group.libraryapp.domain.Book;
import com.group.libraryapp.domain.User;
import com.group.libraryapp.domain.UserLoanHistory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;
    public BookService(BookRepository bookRepository, UserLoanHistoryRepository userLoanHistoryRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }
    @Transactional
    public void addBook(CreateBookDTO request) {
        bookRepository.save(new Book(request.getName()));
    }

    @Transactional
    public void loanBook(LoanBookDTO request) {
        Book book = bookRepository.findByName(request.getBookName()).orElseThrow(IllegalAccessError::new);

        if(userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false)) {
            throw new IllegalArgumentException("대출 되어 있는 책 입니다.");
        }
        User user = userRepository.findByName(request.getUserName()).orElseThrow(IllegalAccessError::new);

        userLoanHistoryRepository.save(new UserLoanHistory(user, book.getName()));
    }

    @Transactional
    public void returnBook(LoanBookDTO request) {
        User user = userRepository.findByName(request.getUserName()).orElseThrow(IllegalAccessError::new);

        UserLoanHistory history = userLoanHistoryRepository.findByUserIdAndBookName(user.getId(), request.getBookName()).orElseThrow(IllegalArgumentException::new);
        history.setReturn(true);
    }
}
