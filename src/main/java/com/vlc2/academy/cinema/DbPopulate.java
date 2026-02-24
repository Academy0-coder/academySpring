package com.vlc2.academy.cinema;

import com.vlc2.academy.cinema.dto.request.ShowCreate;
import com.vlc2.academy.cinema.dto.request.TicketCreate;
import com.vlc2.academy.cinema.entity.Movie;
import com.vlc2.academy.cinema.entity.Show;
import com.vlc2.academy.cinema.entity.Theater;
import com.vlc2.academy.cinema.entity.Watcher;
import com.vlc2.academy.cinema.repository.*;
import com.vlc2.academy.cinema.service.ShowService;
import com.vlc2.academy.cinema.service.TicketService;
import com.vlc2.academy.cinema.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

// class used to populate the db
 @SpringBootApplication
public class DbPopulate implements CommandLineRunner {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowService showService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private WatcherRepository watcherRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private Utils util;

    public boolean generateRandomShow(){

        Theater theater = theaterRepository.findById(util.randomNumber(theaterRepository.countAll())).get();
        Movie movie = movieRepository.findById(util.randomNumber(movieRepository.countAll())).get();

        LocalDateTime beginTime = util.randomTime(LocalTime.of(18,00),
                LocalTime.of(22,30),
                10,
                LocalDate.of(2026,02,15),
                LocalDate.of(2026,03,15));


        ShowCreate generated = new ShowCreate(beginTime,theater.getId(),movie.getId());
        try{
            showService.save(generated);
            return true;
        }
        catch(RuntimeException exc){
            return false;
        }



    }

    public boolean generateRandomTicket(){

        Show show = showRepository.findById(util.randomNumber(showRepository.countAll())).get();
        Watcher watcher = watcherRepository.findById(util.randomNumber(watcherRepository.countAll())).get();
        Integer seatNumber = util.randomNumber(show.getTheater().getSeats());
        char row = (char) (96+util.randomNumber(show.getTheater().getRows()));

        TicketCreate generated = new TicketCreate(row,seatNumber,watcher.getId(),show.getId());

        try{
            ticketService.save(generated);
            return true;
        }
        catch(RuntimeException exc){
            return false;
        }


    }

    public void populateShows (Integer number){

        Integer counter = 0;
        while (counter < number){
            if(generateRandomShow()){
                counter++;
            }
        }
    }

    public void populateTickets (Integer number){

        Integer counter = 0;
        while (counter < number){
            if(generateRandomTicket()){
                counter++;
            }
        }
    }


    @Override
    public void run(String[] args){

        populateShows(100);
        populateTickets(1000);
    }



    static void main(String[] args) {

        SpringApplication.run(DbPopulate.class, args);

    }
}
