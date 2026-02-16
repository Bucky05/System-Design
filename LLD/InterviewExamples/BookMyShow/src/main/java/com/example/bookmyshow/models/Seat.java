package com.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Seat extends BaseModel{

    private String seatNumber;

    private int rowValue;

    private int colValue;

    @Enumerated(EnumType.ORDINAL) // will keep based on index
    private SeatType seatType;

    @ManyToOne
    private Auditorium auditorium;

    @OneToMany(mappedBy = "seat")
    private List<ShowSeat> showSeatList;
}
