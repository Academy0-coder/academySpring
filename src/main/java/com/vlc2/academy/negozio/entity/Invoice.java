package com.vlc2.academy.negozio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Entity
@Table(schema = "store", name = "invoice")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "taxable")
    private Double taxable;

    @Column(name = "total")
    private Double total;

    @Column(name = "execution_instance")
    private Instant timestamp;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Invoice(int quantity, Customer customer, Product product, Instant timestamp){
        this.quantity = quantity;
        this.customer = customer;
        this.product = product;
        this.timestamp = timestamp;
        taxable = quantity * product.getPrice();
        total = taxable * 1.22;
    }

}
