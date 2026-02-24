package com.vlc2.academy.cinema.controller;

import com.vlc2.academy.cinema.command.TicketCommand;
import com.vlc2.academy.cinema.dto.request.TicketCreate;
import com.vlc2.academy.cinema.dto.request.TicketRead;
import com.vlc2.academy.cinema.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Tag(name = "Tickets")
@RestController()
public class TicketController {

    private TicketService ticketService;
    private BeanFactory beanFactory;

    @PostMapping("/tickets")
    @Operation(summary = "Insert a new ticket", description = "Fields required are: seat number, show id and watcher id")
    public ResponseEntity<TicketRead> saveTicket(@RequestBody TicketCreate request){
        TicketCommand ticketCommand = beanFactory.getBean(TicketCommand.class, ticketService, request);
        return ResponseEntity.ok(ticketCommand.execute());
    }

    @GetMapping("/tickets")
    @Operation(summary = "Get all tickets", description = "Select a page and a size")
    public ResponseEntity<Page<TicketRead>> getAllTickets(Integer page, Integer size) {
        return ResponseEntity.ok(ticketService.findAll(page , size));
    }

    @GetMapping("/tickets/{id}")
    @Operation(summary = "Find a ticket", description = "Find a ticket by id")
    public ResponseEntity<TicketRead> getTicketById(@PathVariable Integer id) {
        return ResponseEntity.ok(ticketService.findById(id));
    }
}