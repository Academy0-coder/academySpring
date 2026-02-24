package com.vlc2.academy.cinema.dto;

import com.vlc2.academy.cinema.entity.Movie;
import com.vlc2.academy.cinema.entity.Theater;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShowDTO {

    private Integer id;
    private Integer freeSeats;
    private LocalDateTime begin;
    private LocalDateTime end;
    private Theater theater;
    private Movie movie;
    private Map<String,Boolean> seats;

    public ShowDTO(Integer freeSeats, LocalDateTime begin, LocalDateTime end, Theater theater, Movie movie) {
        this.freeSeats = freeSeats;
        this.begin = begin;
        this.end = end;
        this.theater = theater;
        this.movie = movie;
    }
}
