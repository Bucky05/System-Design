package models.parking;

import java.util.List;

public class ParkingFloor {

    private int floorNumber;
    private List<ParkingSlot> parkingSlots;

    public ParkingFloor(int floorNumber, List<ParkingSlot> parkingSlots) {
        this.floorNumber = floorNumber;
        this.parkingSlots = parkingSlots;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public boolean addParkingSlot(ParkingSlot parkingSlots) {
        return false;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}
