package com.vlc2.academy.cinema.dto;

import com.vlc2.academy.cinema.entity.Movie;
import com.vlc2.academy.cinema.entity.Theater;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShowDTO {

    private Integer id;
    private Integer seatsTaken;
    private LocalDateTime begin;
    private Theater theater;
    private Movie movie;

    public ShowDTO(Integer seatsTaken, LocalDateTime begin, Theater theater, Movie movie) {
        this.seatsTaken = seatsTaken;
        this.begin = begin;
        this.theater = theater;
        this.movie = movie;
    }
}
