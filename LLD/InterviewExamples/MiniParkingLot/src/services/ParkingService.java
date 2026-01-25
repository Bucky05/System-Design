package services;

import factories.TicketFactory;
import factories.VehicleFacotry;
import models.Slot;
import models.Vehicle;
import java.util.List;
import repositories.Repository;
import repositories.RepositoryImpl;
import models.Ticket;

public class ParkingService {

    int ticketCount ;
    Repository repository;

    public ParkingService() {
        repository = new RepositoryImpl();
        ticketCount = 0;
    }

    public Ticket bookSlot(int vehicleNumber, int sizeOfVehicle) {
        Vehicle vehicle = VehicleFacotry.creatVehicle(vehicleNumber,sizeOfVehicle);
        Slot availableSlot = getAvailableSlot(sizeOfVehicle);
        if(availableSlot == null) {
            System.out.println("No available slot available");
            return null;
        } else {
            availableSlot.updateAvailableStatus(false);
            Ticket ticket = TicketFactory.createTicket(++ticketCount,availableSlot, vehicle);
            repository.getTicket().add(ticket);
            return ticket;
        }
    }

    public boolean freeSlot(Ticket ticket) {

        for(Ticket tkt : repository.getTicket()) {
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
    private Slot getAvailableSlot(int sizeOfVehicle) {
        List<Slot> slots = repository.getSlot();

        for(Slot slot : slots) {
            if(slot.getAvailabilityStatus() && slot.getSizeOfVehicleAllowed() == sizeOfVehicle) {
                return slot;
            }
        }

        return null;
    }
}
