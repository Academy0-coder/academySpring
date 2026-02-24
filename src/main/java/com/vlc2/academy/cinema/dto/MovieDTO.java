package com.vlc2.academy.cinema.dto;

import com.vlc2.academy.cinema.entity.other.MovieType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieDTO {

    private Integer id;
    private String name;
    private String directorName;
    private MovieType genre;
    private Double rating;
    private Double price;
    private Integer length;
    private Double revenue;

    public MovieDTO(String name, String directorName, MovieType genre, Double rating, Double price, Integer length) {
        this.name = name;
        this.directorName = directorName;
        this.genre = genre;
        this.rating = rating;
        this.price = price;
        this.length = length;
        this.revenue = 0.0;
    }
}
