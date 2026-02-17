package com.vlc2.academy.cinema.dto;

import com.vlc2.academy.cinema.entity.other.Membership;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WatcherDTO {

    private Integer id;
    private String name;
    private String surname;
    private Integer score;
    private Membership card;

    public WatcherDTO(String name, String surname, Integer score, Membership card) {
        this.name = name;
        this.surname = surname;
        this.score = score;
        this.card = card;
    }

    public Double applyDiscount(Double price){

        Double result = price;
        switch(card){
            case SILVER -> price *= 0.8;
            case GOLD -> price *= 0.6;
        }
        return result;
    }
}
