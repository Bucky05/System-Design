package PrototypePattern.NaiveSolution;

public class Main {
    Email email = new Email("abc@gmail.com","dest@gmail.com","Hi There");

    Email copy = new Email(email);

    copy.display();
}
