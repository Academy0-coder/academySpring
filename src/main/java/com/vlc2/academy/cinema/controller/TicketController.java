package com.vlc2.academy.cinema.controller;

import com.vlc2.academy.cinema.command.TicketCommand;
import com.vlc2.academy.cinema.dto.TicketDTO;
import com.vlc2.academy.cinema.dto.request.TicketCreate;
import com.vlc2.academy.cinema.dto.request.TicketRead;
import com.vlc2.academy.cinema.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController()
public class TicketController {

    private TicketService ticketService;
    private BeanFactory beanFactory;

    @PostMapping("/tickets")
    public ResponseEntity<TicketRead> saveTicket(@RequestBody TicketCreate request){
        TicketCommand ticketCommand = beanFactory.getBean(TicketCommand.class, ticketService, request);
        return ResponseEntity.ok(ticketCommand.execute());
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<TicketRead>> getAllTickets() {
        return ResponseEntity.ok(ticketService.findAll());
    }

    @GetMapping("/tickets/{id}")
    public ResponseEntity<TicketRead> getTicketById(@PathVariable Integer id) {
        return ResponseEntity.ok(ticketService.findById(id));
    }
}