package repositories;

import java.util.ArrayList;
import models.Slot;
import java.util.List;
import models.Ticket;
import db.DB;

public class RepositoryImpl implements  Repository{

    List<Slot> slotList ;
    List<Ticket> ticketList;

    public RepositoryImpl() {
        slotList = DB.seeder();
        ticketList = new ArrayList<>();
    }


    @Override
    public List<Slot> getSlot() {
        return slotList;
    }

    @Override
    public List<Ticket> getTicket() {
        return ticketList;
    }
}
