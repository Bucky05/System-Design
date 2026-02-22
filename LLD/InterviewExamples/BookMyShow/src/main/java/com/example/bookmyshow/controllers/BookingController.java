package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dto.BlockedSeatsRequestDto;
import com.example.bookmyshow.dto.BookSeatsRequestDto;
import com.example.bookmyshow.models.Ticket;
import com.example.bookmyshow.services.BookingService;
import org.springframework.cglib.core.Block;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/block")
    public boolean blockSeats(@RequestBody BlockedSeatsRequestDto blockedSeatsRequestDto) {
        return bookingService.blockSeats(blockedSeatsRequestDto.getShowId(),blockedSeatsRequestDto.getSeatIdList(),blockedSeatsRequestDto.getUserId());
    }

    @DeleteMapping
    public void clearAllSeatLock() {
        bookingService.clearAllSeatLocks();
    }

    @PostMapping("/confirm")
    public Optional<Ticket> confirmBooking(@RequestBody BookSeatsRequestDto bookSeatsRequestDto) {
        return bookingService.confirmBooking(bookSeatsRequestDto.getShowId(),bookSeatsRequestDto.getSeatIdList(),bookSeatsRequestDto.getUserId());
    }
}
