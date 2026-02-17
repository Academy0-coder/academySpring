package com.vlc2.academy.negozio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "store", name = "product")
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "quantity_sold")
    private Integer quantitySold;

    @OneToMany(mappedBy = "product")
    private List<Invoice> invoices;


    public Product(String name, Double price, Integer quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        quantitySold = 0;
        invoices = new ArrayList<>();
    }

    public void addInvoice (Invoice invoice){
        invoices.add(invoice);
    }

}
