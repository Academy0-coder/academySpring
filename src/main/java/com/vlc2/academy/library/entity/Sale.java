package com.vlc2.academy.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sale")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "month_sale")
    private Integer month;

    @Column(name = "week_sale")
    private Integer week;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Sale(Integer month, Integer week, Book book) {
        this.month = month;
        this.week = week;
        this.book = book;
    }

}