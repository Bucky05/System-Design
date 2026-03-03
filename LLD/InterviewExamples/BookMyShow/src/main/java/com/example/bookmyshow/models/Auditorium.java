package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Auditorium extends BaseModel{

    private String name;

    private int capacity;

    @ManyToOne
    private Theatre theatre;

    @OneToMany(mappedBy = "auditorium") // it shows auditorium will be foreign key and thus will not create column here.
    private List<Seat> seatList;

    @OneToMany(mappedBy = "auditorium") // if mapped by is is not included it will not create a foreign key instead it will create a join table
    private List<Show> showList;
}
