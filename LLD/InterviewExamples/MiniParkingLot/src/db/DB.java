package db;
import factories.SlotFactory;
import models.Slot;
import java.util.List;
import java.util.ArrayList;
public class DB {

    public static List<Slot> seeder() {
        List<Slot> slotList = new ArrayList<>();

        for(int i = 0 ; i < 3 ; i++) {
            slotList.add(SlotFactory.createSlot(i,i,2));
        }
        return slotList;
    }
}
