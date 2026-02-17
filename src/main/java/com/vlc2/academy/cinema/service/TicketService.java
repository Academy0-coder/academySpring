package com.vlc2.academy.cinema.service;

import com.vlc2.academy.cinema.dto.TicketDTO;
import com.vlc2.academy.cinema.dto.WatcherDTO;
import com.vlc2.academy.cinema.dto.request.TicketCreate;
import com.vlc2.academy.cinema.dto.request.TicketRead;

import java.util.List;

public interface TicketService {

    // CREATE
    // Save a new ticket
    TicketRead save(TicketCreate ticketRequest);

    // READ
    // Find all tickets
    List<TicketRead> findAll();
    // Find a ticket by id
    TicketRead findById(Integer id);
}


