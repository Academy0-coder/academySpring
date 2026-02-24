package com.vlc2.academy.cinema.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShowRead {

    private Integer id;
    private Integer freeSeats;
    private LocalDateTime begin;
    private LocalDateTime end;
    private String theater;
    private String movie;

}
