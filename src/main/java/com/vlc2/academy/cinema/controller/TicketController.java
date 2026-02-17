package com.vlc2.academy.cinema.controller;

import com.vlc2.academy.cinema.dto.TicketDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TicketController {

    // POST REQUEST
    // save a new ticket
    ResponseEntity<TicketDTO> saveTicket(TicketDTO request);

    // GET REQUEST
    // get all tickets
    ResponseEntity<List<TicketDTO>> getAllTickets ();

    // get a ticket by id
    ResponseEntity<TicketDTO> getTicketById (Integer id);

}
