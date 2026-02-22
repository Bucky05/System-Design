package com.example.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookSeatsRequestDto {
    private long showId;
    private long userId;
    private List<Long> seatIdList;
}
