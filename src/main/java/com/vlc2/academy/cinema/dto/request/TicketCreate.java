package com.vlc2.academy.cinema.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TicketCreate {

    private char row;
    private Integer seatNumber;
    private Integer watcherId;
    private Integer showId;
}
