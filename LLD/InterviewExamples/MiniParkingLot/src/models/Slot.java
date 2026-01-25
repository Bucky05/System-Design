package models;

public class Slot {

    private final int slotID;
    private final int distanceFromMainGate;
    private final int sizeOfVehicleAllowed;
    private boolean isAvailable;
    public Slot(int slotID, int distanceFromMainGate, int sizeOfVehicleAllowed) {
        this.slotID = slotID;
        this.distanceFromMainGate = distanceFromMainGate;
        this.sizeOfVehicleAllowed = sizeOfVehicleAllowed;
        isAvailable = true;
    }
    public int getSlotID() {
        return slotID;
    }

    public int getDistanceFromMainGate() {
        return distanceFromMainGate;
    }

    public int getSizeOfVehicleAllowed() {
        return sizeOfVehicleAllowed;
    }

    public boolean getAvailabilityStatus() {
        return isAvailable;
    }
    public void updateAvailableStatus(boolean status) {
        isAvailable = status;
    }
}
