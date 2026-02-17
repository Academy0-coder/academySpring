package com.vlc2.academy.cinema.mapper;

import com.vlc2.academy.cinema.entity.Ticket;
import com.vlc2.academy.cinema.dto.TicketDTO;

import java.util.List;

@org.mapstruct.Mapper
public interface TicketMapper {

    Ticket toEntity (TicketDTO ticketDTO);

    TicketDTO toDto (Ticket ticket);

    List<TicketDTO> listToDto (List<Ticket> tickets);
}