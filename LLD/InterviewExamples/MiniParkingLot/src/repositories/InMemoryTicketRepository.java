package repositories;

import models.Ticket;
import java.util.List;
import java.util.ArrayList;
public class InMemoryTicketRepository implements TicketRepository{

    private final List<Ticket> ticketList;

    public InMemoryTicketRepository() {
        ticketList = new ArrayList<>();

    }

    @Override
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    @Override
    public void save(Ticket ticket) {
        ticketList.add(ticket);
    }

}
