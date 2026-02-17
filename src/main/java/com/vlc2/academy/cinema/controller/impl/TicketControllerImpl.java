package com.vlc2.academy.cinema.controller.impl;

import com.vlc2.academy.cinema.command.TicketCommand;
import com.vlc2.academy.cinema.controller.TicketController;
import com.vlc2.academy.cinema.dto.TicketDTO;
import com.vlc2.academy.cinema.service.TicketService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class TicketControllerImpl implements TicketController {

    private TicketService ticketService;
    private BeanFactory beanFactory;

    @PostMapping("/tickets")
    public ResponseEntity<TicketDTO> saveTicket(@RequestBody TicketDTO request){
        TicketCommand ticketCommand = beanFactory.getBean(TicketCommand.class, ticketService, request);
        return ResponseEntity.ok(ticketCommand.execute());
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<TicketDTO>> getAllTickets() {
        return ResponseEntity.ok(ticketService.findAll());
    }

    @GetMapping("/tickets/{id}")
    public ResponseEntity<TicketDTO> getTicketById(@PathVariable Integer id) {
        return ResponseEntity.ok(ticketService.findById(id));
    }
}