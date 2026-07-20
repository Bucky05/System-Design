package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Section {

    public  int id;
    public  List<Shelf> shelves;
    public Floor floor;
    public Section(int id, Floor floor) {
        this.id = id;
        this.shelves = new ArrayList<>();
        this.floor = floor;
    }

    public void addShelf(Shelf shelf) {
        shelves.add(shelf);
    }
}
