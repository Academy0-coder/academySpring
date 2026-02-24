package com.vlc2.academy.cinema.service;

import com.vlc2.academy.cinema.dto.request.TicketCreate;
import com.vlc2.academy.cinema.dto.request.TicketRead;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TicketService {

    // CREATE
    // Save a new ticket
    TicketRead save(TicketCreate ticketRequest);

    // READ
    // Find all tickets
    Page<TicketRead> findAll(Integer page, Integer size);
    // Find a ticket by id
    TicketRead findById(Integer id);
}


