package org.example.services;

import org.example.models.*;
import org.example.repositories.*;

import java.util.List;

public class BookService {

    BookRepository bookRepo;
    BorrowRepository borrowRepo;
    FloorRepository floorRepo;
    SectionRepository sectionRepo;
    ShelfRepository shelfRepo;

    public BookService(BookRepository bookRepo,
                       BorrowRepository borrowRepo,
                       FloorRepository floorRepo,
                       SectionRepository sectionRepo,
                       ShelfRepository shelfRepo) {
        this.bookRepo = bookRepo;
        this.borrowRepo = borrowRepo;
        this.floorRepo = floorRepo;
        this.sectionRepo = sectionRepo;
        this.shelfRepo = shelfRepo;
    }

    public Book addBook(String name, String author, Shelf shelf) {

        // should create factory here
        Book book = new Book(bookRepo.books.size(), name,author,shelf);
        bookRepo.add(book);
        shelf.addBook(book);
        return book;

    }

    public void removeBook(Book book) {
        bookRepo.remove(book);
        book.shelf.removeBook(book);
    }

    public Shelf addShelf(Section section) {
        Shelf shelf = new Shelf(shelfRepo.shelves.size(),section);
        section.addShelf(shelf);
        shelfRepo.add(shelf);
        return shelf;
    }

    public Floor addFloor() {
        Floor floor = new Floor(floorRepo.floors.size());
        floorRepo.floors.add(floor);
        return floor;
    }

    public Section addSection(Floor floor) {
        Section section = new Section(sectionRepo.sections.size(),floor);
        floor.addSection(section);
        sectionRepo.add(section);
        return section;
    }

    public Borrow borrowBook(User user, Book book) {
        if(isAvailable(book)) {
            Borrow borrow = borrowRepo.add(user,book);
            System.out.println("Book "+book.name+ " has been issued by "+ user.name);
            return borrow;
        }
        System.out.println("Book "+ book.name+ " is already issued by: "+ getBorrower(book));
        return null;
    }

    private boolean isAvailable(Book book) {
        return bookRepo.isAvailable(book) && borrowRepo.isAvailable(book);
    }

    public User getBorrower(Book book) {
        return borrowRepo.getBorrower(book);
    }

    public List<Book> getBooksBorrowed(User user) {
        List<Book> books = borrowRepo.getBooks(user);

        for(Book b : books) {
            System.out.println(b.name);
        }
        return books;
    }

    public void returnBook(Borrow borrow) {
        borrowRepo.returnBook(borrow);
    }

}
