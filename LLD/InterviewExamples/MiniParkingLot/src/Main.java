import enums.Strategy;
import factories.VehicleFacotry;
import models.Vehicle;
import services.ParkingService;
import models.Ticket;
import models.Car;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ParkingService service = new ParkingService();


        Ticket ticket1 = service.bookSlot(1234,2, Strategy.NEAREST_SLOT_ALLOCATION_STRATEGY);
        Ticket ticket2 = service.bookSlot(2321,3, Strategy.NEAREST_SLOT_ALLOCATION_STRATEGY);
        Ticket ticket3 = service.bookSlot(4223,2, Strategy.NEAREST_SLOT_ALLOCATION_STRATEGY);
        Ticket ticket4 = service.bookSlot(3333,2, Strategy.NEAREST_SLOT_ALLOCATION_STRATEGY);
        Ticket ticket6 = service.bookSlot(3333,2, Strategy.NEAREST_SLOT_ALLOCATION_STRATEGY);
        service.freeSlot(ticket1);
        Ticket ticket5 = service.bookSlot(3333,2, Strategy.NEAREST_SLOT_ALLOCATION_STRATEGY);
        service.freeSlot(ticket1);
        service.freeSlot(ticket2);
    }
}