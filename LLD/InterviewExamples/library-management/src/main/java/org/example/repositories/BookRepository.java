package org.example.repositories;

import org.example.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    public List<Book> books;

    public BookRepository() {
        books = new ArrayList<>();
    }
    public void add(Book book) {
        books.add(book);
    }

    public void remove(Book book) {
        books.remove(book);
    }

    public boolean isAvailable(Book book) {
        for(Book b : books) {
            if(b == book) return true;
        }
        return false;
    }
}
