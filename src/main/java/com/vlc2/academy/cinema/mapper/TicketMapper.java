package com.vlc2.academy.cinema.mapper;

import com.vlc2.academy.cinema.dto.ShowDTO;
import com.vlc2.academy.cinema.dto.request.ShowRead;
import com.vlc2.academy.cinema.dto.request.TicketRead;
import com.vlc2.academy.cinema.entity.Ticket;
import com.vlc2.academy.cinema.dto.TicketDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    Ticket toEntity (TicketDTO ticketDTO);

    TicketDTO toDto (Ticket ticket);

    List<TicketDTO> listToDto (List<Ticket> tickets);

    @Mapping(source = "show.movie.name", target = "show")
    @Mapping(source = "watcher.fullName", target = "watcher")
    TicketRead read (TicketDTO ticket);

    @Mapping(source = "show.movie.name", target = "show")
    @Mapping(source = "watcher.fullName", target = "watcher")
    List<TicketRead> read (List<TicketDTO> dto);
}