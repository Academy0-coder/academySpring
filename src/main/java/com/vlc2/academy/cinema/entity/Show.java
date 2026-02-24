package com.vlc2.academy.cinema.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(schema = "cinema", name = "movie_show")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "number_free_seats")
    private Integer freeSeats;

    @Column(name = "show_begin")
    private LocalDateTime begin;

    @Column(name = "show_end")
    private LocalDateTime end;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @OneToMany(mappedBy = "show")
    List<Ticket> tickets;

    public Show(Integer freeSeats, LocalDateTime begin, LocalDateTime end, Theater theater, Movie movie) {
        this.freeSeats = freeSeats;
        this.begin = begin;
        this.end = end;
        this.theater = theater;
        this.movie = movie;
    }
}