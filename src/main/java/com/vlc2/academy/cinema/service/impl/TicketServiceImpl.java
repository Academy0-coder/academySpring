package com.vlc2.academy.cinema.service.impl;

import com.vlc2.academy.cinema.entity.Ticket;
import com.vlc2.academy.cinema.dto.TicketDTO;
import com.vlc2.academy.cinema.exception.TicketNotFound;
import com.vlc2.academy.cinema.mapper.TicketMapper;
import com.vlc2.academy.cinema.repository.TicketRepository;
import com.vlc2.academy.cinema.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    TicketRepository ticketRepository;
    TicketMapper ticketMapper;

    @Override
    public TicketDTO save(TicketDTO request) {
        Ticket save = ticketMapper.toEntity(request);
        ticketRepository.save(save);

        Ticket ticket = ticketRepository.findLast().get();
        TicketDTO response = ticketMapper.toDto(ticket);
        return response;
    }

    @Override
    public List<TicketDTO> findAll() {
        List<Ticket> tickets = ticketRepository.findAll();
        List<TicketDTO> response = ticketMapper.listToDto(tickets);
        return response;
    }

    @Override
    public TicketDTO findById(Integer id)  {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFound(String.format("There's no ticket with id %d",id)));
        TicketDTO response = ticketMapper.toDto(ticket);
        return response;
    }

}