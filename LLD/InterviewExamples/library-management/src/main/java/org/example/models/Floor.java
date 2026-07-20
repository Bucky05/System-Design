package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    public  int id;
    public  List<Section> sections;

    public Floor(int id) {
        this.id = id;
        this.sections = new ArrayList<>();
    }

    public void addSection(Section section) {
        this.sections.add(section);
    }
}
