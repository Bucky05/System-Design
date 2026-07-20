package org.example.repositories;

import org.example.models.Shelf;

import java.util.ArrayList;
import java.util.List;

public class ShelfRepository {

    public List<Shelf> shelves;

    public ShelfRepository() {
        this.shelves = new ArrayList<>();
    }

    public void add(Shelf shelf) {
        shelves.add(shelf);
    }

    public void remove(Shelf shelf) {
        shelves.remove(shelf);
    }
}
