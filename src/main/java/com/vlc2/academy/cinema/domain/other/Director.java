package com.vlc2.academy.cinema.domain.other;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Director extends Person {

    public Director(String name, String surname, LocalDate dob) {
        super(name, surname, dob);
    }
}
