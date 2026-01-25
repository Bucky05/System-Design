package models;

import java.util.Date;
public class Ticket {

    private final int ticketNumber;
    private final Slot slot;
    private final Vehicle vehicle;
    private final Date startTime;
    private boolean isActive;
    public Ticket(int ticketNumber, Slot slot, Vehicle vehicle) {
        this.ticketNumber = ticketNumber;
        this.slot = slot;
        this.vehicle = vehicle;
        this.startTime = new Date();
        this.isActive = true;
    }


    public int getTicketNumber() {
        return this.ticketNumber;
    }
    public Date getStartTime(){
        return this.startTime;
    }
    public Slot getSlot() {
        return this.slot;
    }
    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public boolean getActiveStatus() {
        return this.isActive;
    }

    public void updateActiveStatus(boolean status) {
        this.isActive = status;
    }

}
