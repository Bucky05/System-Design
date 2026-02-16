package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name="shows") // show is reserved keyword for mysql
@Getter
@Setter
public class Show extends BaseModel{

    @ManyToOne
    private Movie movie;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    private Auditorium auditorium;

}
