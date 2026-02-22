package com.example.bookmyshow.services;


import com.example.bookmyshow.models.*;
import com.example.bookmyshow.repositories.ShowRepository;
import com.example.bookmyshow.repositories.ShowSeatRepository;
import com.example.bookmyshow.repositories.TicketRepository;
import com.example.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RedisBookingService implements BookingService {

    private final CacheService cacheService;
    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public RedisBookingService(RedisService cacheService,
                               ShowSeatRepository showSeatRepository,
                               TicketRepository ticketRepository,
                               UserRepository userRepository,
                               ShowRepository showRepository) {
        this.showRepository = showRepository;
        this.userRepository = userRepository;
        this.cacheService = cacheService;
        this.showSeatRepository = showSeatRepository;
        this.ticketRepository = ticketRepository;
    }
    @Override
    public boolean blockSeats(long showId, List<Long> seatIdList, long userId) {

        System.out.println("Printing cache before logic");
        cacheService.getAllKeysAndValues();
        //1. Check if seats are available
        // a. Check if are not booked

        List<ShowSeat> showSeatList = showSeatRepository.findAllByShowIdAndSeatIdIn(showId,seatIdList);
        System.out.println("Printing all the show seats");
        showSeatList.forEach(showSeat -> {
            System.out.println(showSeat.getId() +" "+showSeat.getStatus());
        });
        for(ShowSeat showSeat : showSeatList) {
            if(showSeat.getStatus().equals(ShowSeatStatus.BOOKED)) {
                return false;
            }
        }
        // b. Check if the seats are not locked
        for(ShowSeat seat: showSeatList) {
            String status = (String) cacheService.get("seatId-"+seat.getId()+"-showId-"+showId);

            if(status != null) return false;
        }
        //2. Block the seats

        for(ShowSeat seat : showSeatList) {
            cacheService.set("seatId-"+seat.getId()+"-showId-"+showId,userId);
        }

        System.out.println("Printing cache after logic");
        cacheService.getAllKeysAndValues();
        return true;
    }

    @Override
    @Transactional
    public Optional<Ticket> confirmBooking(long showId, List<Long> showSeatIdList, long userId) {
        // check if user has locked all the seats
        System.out.println("Printing cache after logic");
        cacheService.getAllKeysAndValues();
        for(Long seatId : showSeatIdList) {

            String bookedByUser =   (String) cacheService.get("seatId-"+seatId+"-showId-"+showId);

            if(bookedByUser == null ) {
                return Optional.empty();
            }

            long bookedByUserId = Long.parseLong(bookedByUser);
            if(bookedByUserId != userId) {
                return Optional.empty();
            }
        }

        User user = userRepository.findById(userId).get();
        Show show = showRepository.findById(showId).get();
        //update status of all showSeat and ticket id

        Ticket t = createTicketAndBookSeats(show, showSeatIdList,user);

        return Optional.of(t);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    protected Ticket createTicketAndBookSeats(Show show, List<Long> seatIdList, User user) {
        // Create a new ticket

        Ticket ticket = new Ticket();
        //ticket.setAmount(100L);
        ticket.setShow(show);
        ticket.setUser(user);
        ticket.setStatus(TicketStatus.BOOKED);
        ticket.setCreatedAt(LocalDateTime.now());
        ticket = ticketRepository.save(ticket);
        showSeatRepository.bookShowSeatInBulk(seatIdList,ticket);
        return ticket;
    }

    @Override
    public void clearAllSeatLocks() {
        cacheService.deleteAll();
    }
}

