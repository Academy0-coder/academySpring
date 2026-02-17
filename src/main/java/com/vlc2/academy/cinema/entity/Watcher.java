package com.vlc2.academy.cinema.entity;

import com.vlc2.academy.cinema.entity.other.Membership;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "Watcher")
@Table(schema = "cinema", name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Watcher {

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
    private Membership card;

    public Watcher(String name, String surname, Integer score, Membership card) {
        this.name = name;
        this.surname = surname;
        this.score = score;
        this.card = card;
    }

    public Double applyDiscount(Double price){

        Double result = price;
        switch(card){
            case SILVER -> result *= 0.8;
            case GOLD -> result *= 0.6;
        }
        return result;
    }
}
