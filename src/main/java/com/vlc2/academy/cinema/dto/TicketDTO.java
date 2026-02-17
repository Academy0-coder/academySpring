package com.vlc2.academy.cinema.dto;

import com.vlc2.academy.cinema.entity.Show;
import com.vlc2.academy.cinema.entity.Watcher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TicketDTO {

    private Integer id;
    private Integer seatNumber;
    private Double price;
    private Watcher watcher;
    private Show show;

    public TicketDTO(Integer seatNumber, Double price, Watcher watcher, Show show) {
        this.seatNumber = seatNumber;
        this.price = price;
        this.watcher = watcher;
        this.show = show;
    }
}
