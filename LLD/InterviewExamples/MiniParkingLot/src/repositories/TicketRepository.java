package repositories;

import models.Ticket;
import java.util.List;
public interface TicketRepository {

    public List<Ticket> getTicketList();

    public void save(Ticket ticket);
}
