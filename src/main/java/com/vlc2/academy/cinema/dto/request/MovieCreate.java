package com.vlc2.academy.cinema.dto.request;

import com.vlc2.academy.cinema.entity.other.MovieType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieCreate {

    private String name;
    private String directorName;
    private MovieType genre;
    private Double rating;
    private Double price;
    private Integer length;
}
