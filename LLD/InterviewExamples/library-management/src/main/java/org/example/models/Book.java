package org.example.models;

public class Book {

    // should use getter setter but using public to save time
    public int id;
    public String name;
    public String author;
    public Shelf shelf;

    public Book(int id, String name, String author,Shelf shelf) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.shelf = shelf;

    }

}
