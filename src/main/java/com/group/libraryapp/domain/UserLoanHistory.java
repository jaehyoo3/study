package com.group.libraryapp.domain;

import javax.persistence.*;

@Entity
@Table(name = "user_loan_history")
public class UserLoanHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;
    @Column(name = "book_name")
    private String bookName;

    @Column(name = "isReturn")
    private boolean isReturn;

    protected UserLoanHistory() { }
    public UserLoanHistory(User user, String bookName) {
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false;
    }

    public Long getId() {
        return id;
    }


    public String getBookName() {
        return bookName;
    }
    public boolean isReturn() {
        return isReturn;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setReturn(boolean aReturn) {
        isReturn = true;
    }
}
