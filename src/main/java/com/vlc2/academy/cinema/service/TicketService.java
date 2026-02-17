package com.vlc2.academy.cinema.service;

import com.vlc2.academy.cinema.dto.TicketDTO;
import com.vlc2.academy.cinema.dto.WatcherDTO;

import java.util.List;

public interface TicketService {

    // CREATE
    // Save a new ticket
    TicketDTO save(TicketDTO ticketRequest);

    // READ
    // Find all tickets
    List<TicketDTO> findAll();
    // Find a ticket by id
    TicketDTO findById(Integer id);
}


