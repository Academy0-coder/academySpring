package com.vlc2.academy.cinema.domain.entity;

import com.vlc2.academy.cinema.domain.other.Membership;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Entity(name = "customer")
@NoArgsConstructor
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_surname")
    private String surname;

    @Column(name = "score")
    private Integer score;

    @Enumerated(EnumType.STRING)
    @Column(name = "membership_card")
    private Membership level;

}
