package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Shelf {

    public int id;
    public List<Book> books;
    public Section section;
    public Shelf(int id, Section section) {
        this.id = id;
        this.books = new ArrayList<>();
        this.section = section;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }
}
