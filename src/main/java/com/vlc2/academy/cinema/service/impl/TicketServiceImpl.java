package com.vlc2.academy.cinema.service.impl;

import com.vlc2.academy.cinema.dto.request.TicketCreate;
import com.vlc2.academy.cinema.dto.request.TicketRead;
import com.vlc2.academy.cinema.entity.Movie;
import com.vlc2.academy.cinema.entity.Show;
import com.vlc2.academy.cinema.entity.Ticket;
import com.vlc2.academy.cinema.dto.TicketDTO;
import com.vlc2.academy.cinema.entity.Watcher;
import com.vlc2.academy.cinema.entity.other.Membership;
import com.vlc2.academy.cinema.exception.customs.*;
import com.vlc2.academy.cinema.mapper.TicketMapper;
import com.vlc2.academy.cinema.repository.MovieRepository;
import com.vlc2.academy.cinema.repository.ShowRepository;
import com.vlc2.academy.cinema.repository.TicketRepository;
import com.vlc2.academy.cinema.repository.WatcherRepository;
import com.vlc2.academy.cinema.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TicketServiceImpl implements TicketService {

    TicketRepository ticketRepository;
    TicketMapper ticketMapper;
    ShowRepository showRepository;
    WatcherRepository watcherRepository;
    MovieRepository movieRepository;



    // Method for the creation of a ticket
    @Override
    public TicketRead save(TicketCreate request) {

        // Verify that showId and watcherId correspond to a show and watcher on db
        Show show = showRepository.findById(request.getShowId())
                .orElseThrow(()-> new ShowNotFound("There's no show with id: "+request.getShowId()));

        Watcher watcher = watcherRepository.findById(request.getWatcherId())
                .orElseThrow(()-> new WatcherNotFound("There's no watcher with id: "+request.getWatcherId()));

        Double price = show.getMovie().getPrice();

        // Check that the seat number is available
        if(show.getTheater().getSeats() < request.getSeatNumber()){

            throw new InputInvalid(String.format("You can't assign the seat number %d since the theater %s has only %d seats",
                    request.getSeatNumber(),
                    show.getTheater().getName(),
                    show.getTheater().getSeats()));
        }
        if(ticketRepository.findTicketByShowAndSeatNumber(show, request.getSeatNumber()).isPresent()){

            throw new InvalidBooking(String.format("You can't assign the seat number %d for this show since it's already taken",
                    request.getSeatNumber()));
        }
        if(ticketRepository.findTicketByShowAndWatcher(show, watcher).isPresent()){

            throw new InvalidBooking(String.format("You can't reserve a ticket for %s %s since there's already a booking for this show by their name",
                    watcher.getName(),
                    watcher.getSurname()));
        }

        TicketDTO mapped = new TicketDTO(request.getRow(),
                request.getSeatNumber(),
                watcher.applyDiscount(price),
                watcher,
                show);

        // Update the total revenue of the movie
        Movie movie = show.getMovie();
        movie.setRevenue(movie.getRevenue()+watcher.applyDiscount(price));
        movieRepository.save(movie);


        // Update the score of the watcher (and possibly their membership)
        watcher.setScore(watcher.getScore() + (int) Math.floor(price));

        if(watcher.getScore()>300){
            watcher.setCard(Membership.SILVER);
        }
        if(watcher.getScore()>1000){
            watcher.setCard(Membership.GOLD);
        }

        watcherRepository.save(watcher);


        // Update the number of free seats
        show.setFreeSeats(show.getFreeSeats()-1);
        showRepository.save(show);

        // Save the ticket, return the DTO version of it
        Ticket save = ticketMapper.toEntity(mapped);
        ticketRepository.save(save);

        Ticket ticket = ticketRepository.findLast().get();
        TicketRead response = ticketMapper.read(ticketMapper.toDto(ticket));
        return response;
    }

    @Override
    public Page<TicketRead> findAll(Integer page, Integer size) {

        if(!ticketRepository.isPresent()){
            throw new EmptyListException("There are no tickets in the database");
        }

        if(page <= 0){
            throw new InputInvalid("Page number must be positive");
        }
        else if((page+1)*size > ticketRepository.count()){
            throw new InputInvalid(String.format("There are only %d pages of size %d",
                    (int) Math.ceil((double) ticketRepository.count()/size),
                    size));
        }

        else if(size <= 0){
            throw new InputInvalid("Size number must be positive");
        }

        Pageable pageable = Pageable.ofSize(size).withPage(page-1);
        Page<TicketRead> response = ticketRepository.findAll(pageable).map(ticketMapper::toDto).map(ticketMapper::read);
        return response;
    }

    @Override
    public TicketRead findById(Integer id)  {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFound(String.format("There's no ticket with id %d",id)));
        TicketRead response = ticketMapper.read(ticketMapper.toDto(ticket));
        return response;
    }

}