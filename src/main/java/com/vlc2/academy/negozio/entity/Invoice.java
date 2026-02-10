package com.vlc2.academy.negozio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name = "invoice")
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

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Invoice(int quantity, Customer customer, Product product){
        this.quantity = quantity;
        this.customer = customer;
        this.product = product;
        taxable = quantity * product.getPrice();
        total = taxable * 1.22;
    }

}
