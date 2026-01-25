package factories;

import models.Ticket;
import models.Vehicle;
import models.Slot;
public class TicketFactory {

    public static Ticket createTicket(int ticketNumber, Slot slot, Vehicle vehicle) {
        return new Ticket(ticketNumber,slot,vehicle);
    }
}
