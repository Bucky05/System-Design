package org.example.repositories;

import org.example.models.Book;
import org.example.models.Borrow;
import org.example.models.User;

import java.time.LocalDate;
import java.util.*;

public class BorrowRepository {

    List<Borrow> borrowList;

    public BorrowRepository() {
        borrowList = new ArrayList<>();
    }

    public Borrow add(User user, Book book) {
        Borrow borrow = new Borrow(user, book);
        borrowList.add(borrow);
        return borrow;
    }

    public User getBorrower(Book book) {
        for(Borrow borrow : borrowList) {
            if(borrow.book == book) {
                return borrow.user;
            }
        }
        return null;
    }

    public List<Book> getBooks(User user) {
        List<Book> books = new ArrayList<>();
        for(Borrow borrow : borrowList) {
            if(borrow.user == user) {
                books.add(borrow.book);
            }
        }

        return books;
    }

    public boolean isAvailable(Book book) {
        for(Borrow borrow : borrowList) {
            if(borrow.book == book) {
                return false;
            }
        }
        return true;
    }

    public void returnBook(Borrow borrow) {
        borrowList.remove(borrow);
    }
}
