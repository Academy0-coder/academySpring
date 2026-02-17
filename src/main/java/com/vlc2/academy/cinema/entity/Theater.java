package com.vlc2.academy.cinema.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table
@Entity(name = "movie_theater")
@NoArgsConstructor
@Getter
@Setter
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "theater_name")
    private String name;

    @Column(name = "number_seats")
    private Integer seats;

    @OneToMany(mappedBy = "theater")
    List<Show> shows;
}
