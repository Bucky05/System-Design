package org.example.models;

import java.time.LocalDate;
import java.util.Date;

public class Borrow {

    public User user;
    public Book book;
    public LocalDate issueDate;
    public LocalDate returnDate;

    public Borrow(User user, Book book){
        this.user = user;
        this.book = book;
        issueDate = LocalDate.now();
    }


}
