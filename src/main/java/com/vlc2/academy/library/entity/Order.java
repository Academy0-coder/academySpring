package com.vlc2.academy.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "day_order")
    private LocalDate day;

    @Column(name = "delivered")
    private Boolean delivered;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Order(LocalDate day, Boolean delivered, Book book) {
        this.day = day;
        this.delivered = delivered;
        this.book = book;
    }
}