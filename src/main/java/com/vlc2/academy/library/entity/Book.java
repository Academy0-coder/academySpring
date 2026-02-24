package com.vlc2.academy.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Year;
import java.util.List;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "author_name")
    private String author;

    @Column(name = "book_year")
    private Year year;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "quantity_sold")
    private Integer quantitySold;

    @Column(name = "quantity_in_stock")
    private Integer quantityInStock;

    @Column(name = "threshold")
    private Integer threshold;

    @Column(name = "restock")
    private Integer restock;

    @ManyToOne
    @JoinColumn(name = "editor_id")
    private Editor editor;

    @OneToMany(mappedBy = "book")
    private List<Order> orders;

    @OneToMany(mappedBy = "book")
    private List<Sale> sales;

    public Book(String name, String author, Year year, BigDecimal price, Integer quantitySold, Integer quantityInStock, Integer threshold, Integer restock, Editor editor) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.price = price;
        this.quantitySold = quantitySold;
        this.quantityInStock = quantityInStock;
        this.threshold = threshold;
        this.restock = restock;
        this.editor = editor;
    }
}