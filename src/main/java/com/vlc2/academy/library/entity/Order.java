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
    private LocalDate dayOrder;

    @Column(name = "day_deliver")
    private LocalDate dayDeliver;

    @Column(name = "delivered")
    private Boolean delivered;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Order(LocalDate dayOrder, Boolean delivered, Book book) {
        this.dayOrder = dayOrder;
        this.delivered = delivered;
        this.book = book;
    }
}