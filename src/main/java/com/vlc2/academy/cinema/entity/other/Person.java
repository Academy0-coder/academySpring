package com.vlc2.academy.cinema.entity.other;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@Setter
public abstract class Person {

    private final String name;
    private final String surname;
    private final LocalDate dob;

}
