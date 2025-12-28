package PrototypePattern.BetterSolution;

// no need to implement protoype as EMail already does that
public class PremiumEmail extends Email {

    private String cc;
    private String bcc;

    // Regular constructor
    public PremiumEmail(String sender, String receiver, String body, String cc, String bcc) {
        super(sender, receiver, body);
        this.cc = cc;
        this.bcc = bcc;
    }

    // Copy constructor
    private PremiumEmail(PremiumEmail source) {
        super(source);   // Calls Email(Email source)
        this.cc = source.cc;
        this.bcc = source.bcc;
    }

    // Required override of the abstract copy() method
    @Override
    public PremiumEmail clone() {
        return new PremiumEmail(this);
    }

    // Additional getters & setters
    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    @Override
    public void display() {
        // Reuse the parent display logic, then add extras
        super.display();
        System.out.println("CC: " + cc);
        System.out.println("BCC: " + bcc);
    }
}
