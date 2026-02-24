package com.vlc2.academy.cinema.entity;

import com.vlc2.academy.cinema.entity.other.MovieType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;



@Entity
@Table(schema = "cinema", name = "movie")
@NoArgsConstructor
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "movie_name")
    private String name;

    @Column(name = "director")
    private String directorName;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private MovieType genre;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "price")
    private Double price;

    @Column(name = "length")
    private Integer length;

    @Column(name = "revenue")
    private Double revenue;

    @OneToMany(mappedBy = "movie")
    List<Show> shows;


}
