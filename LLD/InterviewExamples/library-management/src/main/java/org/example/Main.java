package org.example;

import org.example.models.*;
import org.example.repositories.*;
import org.example.services.BookService;
import org.example.services.UserService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        FloorRepository fp = new FloorRepository();
        BookRepository bp = new BookRepository();
        ShelfRepository sp = new ShelfRepository();
        SectionRepository sep = new SectionRepository();
        BorrowRepository bop = new BorrowRepository();
        UserRepository up = new UserRepository();

        BookService svc = new BookService(bp,bop,fp,sep,sp);
        UserService userSvc = new UserService(up);


        Floor f1 = svc.addFloor();
        Section sec1 = svc.addSection(f1);
        Shelf s1 = svc.addShelf(sec1);

        User user1 = userSvc.addUser("Ram");
        User user2 = userSvc.addUser("Lakshman");

        Book book1 = svc.addBook("Bible","Ram",s1);
        Book book2 = svc.addBook("Vinland","Musashi",s1);

        Borrow borrow1 = svc.borrowBook(user1,book1);
        Borrow borrow2 = svc.borrowBook(user2,book1);

        Borrow borrow3 = svc.borrowBook(user2,book2);

        svc.returnBook(borrow1);
        Borrow borrow4 = svc.borrowBook(user2,book1);

        svc.getBooksBorrowed(user1);
        svc.getBooksBorrowed(user2);

    }
}