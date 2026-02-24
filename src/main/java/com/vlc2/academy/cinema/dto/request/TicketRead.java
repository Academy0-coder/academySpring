package com.vlc2.academy.cinema.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TicketRead {

    private Integer id;
    private char row;
    private Integer seatNumber;
    private Double price;
    private String watcher;
    private String show;

}
