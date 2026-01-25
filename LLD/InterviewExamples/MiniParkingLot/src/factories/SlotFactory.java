package factories;

import models.Slot;

public class SlotFactory {

    public static Slot createSlot(int id, int distance, int allowedSize) {
        return new Slot(id,distance,allowedSize);
    }
}
