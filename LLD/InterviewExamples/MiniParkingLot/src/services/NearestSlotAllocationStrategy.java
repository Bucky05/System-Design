package services;

import models.Slot;

import java.util.List;
public class NearestSlotAllocationStrategy implements SlotAllocationStrategy {

    @Override
    public Slot getSlot(List<Slot> slotList, int sizeOfVehicle) {
        for(Slot slot : slotList) {
            if(slot.getAvailabilityStatus() && slot.getSizeOfVehicleAllowed() == sizeOfVehicle) {
                return slot;
            }
        }

        return null;
    }
}
