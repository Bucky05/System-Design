package repositories;

import factories.SlotFactory;
import models.Slot;

import java.util.ArrayList;
import java.util.List;


public class InMemorySlotRepository implements  SlotRepository{

    private final List<Slot> slotList ;

    public InMemorySlotRepository() {
        slotList = new ArrayList<>();

        for(int i = 0 ; i < 3 ; i++) {
            slotList.add(SlotFactory.createSlot(i,i,2));
        }
    }


    @Override
    public List<Slot> getSlotList() {
        return slotList;
    }

}
