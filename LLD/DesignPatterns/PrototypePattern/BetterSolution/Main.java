package PrototypePattern.BetterSolution;

public class Main {
    
    public static void Main(String[] args) {
         Email e1 = new Email("hello@world.com", "", "This is a test email");

        // Create a copy object
        Email e2 = e1.clone(); // this is calling the copy constructor
        e2.setBody("");

        e2.display();

        PremiumEmail pe1 = new PremiumEmail("hellopremium@world.com", "", "This is a test premium email", "cc", "bcc");

        // Create a copy object
        PremiumEmail pe2 = pe1.clone(); // this is calling the copy constructor


    }
}
