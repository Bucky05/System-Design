package services;

import models.Slot;
import java.util.List;
public interface SlotAllocationStrategy {

    public Slot getSlot(List<Slot> slotList, int sizeOfVehicle);

}
