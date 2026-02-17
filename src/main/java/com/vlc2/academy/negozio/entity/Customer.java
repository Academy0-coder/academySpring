package com.vlc2.academy.negozio.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @OneToMany(mappedBy = "customer")
    private List<Invoice> invoices;


    public Customer(String name, String surname){
        this.name = name;
        this.surname = surname;
        invoices = new ArrayList<>();
    }

    public void addInvoice (Invoice invoice){
        invoices.add(invoice);
    }

}
