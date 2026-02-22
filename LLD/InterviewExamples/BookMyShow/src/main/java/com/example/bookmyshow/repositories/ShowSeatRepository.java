package com.example.bookmyshow.repositories;

import com.example.bookmyshow.models.ShowSeat;
import com.example.bookmyshow.models.Ticket;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    List<ShowSeat> findAllByShow(long showId);

    List<ShowSeat> findAllByShowIdAndSeatIdIn(Long showId, List<Long> seatIdList);

    @Modifying
    @Query("UPDATE ShowSeat s SET s.ticket= :ticket, s.status = 1 where s.id IN :idList")
    int bookShowSeatInBulk(@Param("idList") List<Long> idList, @Param("ticketId") Ticket ticket);
}
