package org.example.repositories;

import org.example.models.Section;

import java.util.ArrayList;
import java.util.List;

public class SectionRepository {

    public List<Section> sections;

    public SectionRepository() {
        this.sections = new ArrayList<>();
    }

    public void add(Section section) {
        this.sections.add(section);
    }
    public void remove(Section section) {
        this.sections.remove(section);
    }
}
