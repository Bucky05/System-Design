package services;

import factories.StrategyFactory;
import factories.TicketFactory;
import factories.VehicleFacotry;
import models.Slot;
import models.Vehicle;
import java.util.List;

import repositories.InMemorySlotRepository;
import models.Ticket;
import repositories.InMemoryTicketRepository;
import enums.Strategy;
import repositories.SlotRepository;
import repositories.TicketRepository;

public class ParkingService {

    int ticketCount ;
    SlotRepository slotRepository;
    TicketRepository ticketRepository;

    public ParkingService() {
        slotRepository = new InMemorySlotRepository();
        ticketRepository = new InMemoryTicketRepository();
        ticketCount = 0;
    }

    public Ticket bookSlot(int vehicleNumber, int sizeOfVehicle, Strategy strategy) {
        Vehicle vehicle = VehicleFacotry.creatVehicle(vehicleNumber,sizeOfVehicle);
        Slot availableSlot = getAvailableSlot(sizeOfVehicle,strategy);
        if(availableSlot == null) {
            System.out.println("No available slot available");
            return null;
        } else {
            availableSlot.updateAvailableStatus(false);
            Ticket ticket = TicketFactory.createTicket(++ticketCount,availableSlot, vehicle);
            ticketRepository.save(ticket);
            return ticket;
        }
    }

    public boolean freeSlot(Ticket ticket) {

        for(Ticket tkt : ticketRepository.getTicketList()) {
            if(tkt == ticket) {
                if(tkt.getActiveStatus()) {
                    tkt.updateActiveStatus(false);
                    tkt.getSlot().updateAvailableStatus(true);
                    System.out.println("Thank you visited again");
                    return true;
                } else {
                    System.out.println("Ticket is already used");
                    return false;
                }
            }
        }

        System.out.println("Ticket is not valid");
        return false;
    }
    private Slot getAvailableSlot(int sizeOfVehicle,Strategy stratergy) {
        List<Slot> slots = slotRepository.getSlotList();

        SlotAllocationStrategy slotAllocationStrategy = StrategyFactory.createStrategy(stratergy);
        return slotAllocationStrategy.getSlot(slots, sizeOfVehicle);

    }
}
