package repositories;

import models.Slot;
import models.Ticket;
import java.util.List;
public interface Repository {

    public List<Slot> getSlot();

    public List<Ticket> getTicket();
}
