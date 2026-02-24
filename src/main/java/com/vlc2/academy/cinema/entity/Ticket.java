package com.vlc2.academy.cinema.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "cinema", name = "ticket")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "row_letter")
    private char row;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Watcher watcher;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    public Ticket(Integer seatNumber, Double price, Watcher watcher, Show show) {
        this.seatNumber = seatNumber;
        this.price = price;
        this.watcher = watcher;
        this.show = show;
    }
}
