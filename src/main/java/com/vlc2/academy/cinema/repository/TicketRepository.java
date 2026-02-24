package com.vlc2.academy.cinema.repository;

import com.vlc2.academy.cinema.entity.Show;
import com.vlc2.academy.cinema.entity.Ticket;
import com.vlc2.academy.cinema.entity.Watcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {

    @Query("SELECT EXISTS (SELECT 1 FROM Ticket t)")
    Boolean isPresent();

    @Query(value = "SELECT * FROM ticket ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Optional<Ticket> findLast();

    @Query("SELECT t FROM Ticket t WHERE t.show = :show AND t.seatNumber = :seatNumber")
    Optional<Ticket> findTicketByShowAndSeatNumber(Show show, Integer seatNumber);

    @Query("SELECT t FROM Ticket t WHERE t.show = :show AND t.watcher = :watcher")
    Optional<Ticket> findTicketByShowAndWatcher(Show show, Watcher watcher);

    Page<Ticket> findAll(Pageable pageable);
}
