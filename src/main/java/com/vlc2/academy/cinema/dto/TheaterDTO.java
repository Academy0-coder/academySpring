package com.vlc2.academy.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TheaterDTO {

    private Integer id;
    private String name;
    private Integer seats;

    public TheaterDTO(String name, Integer seats) {
        this.name = name;
        this.seats = seats;
    }
}
