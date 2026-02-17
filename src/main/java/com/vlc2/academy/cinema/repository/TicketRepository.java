package com.vlc2.academy.cinema.repository;

import com.vlc2.academy.cinema.entity.Ticket;
import com.vlc2.academy.cinema.entity.Watcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {

    @Query("SELECT t FROM ticket t ORDER BY t.id DESC LIMIT 1")
    Optional<Ticket> findLast();
}
