package com.vlc2.academy.cinema.exception.customs;

public class InvalidBooking extends RuntimeException {
    public InvalidBooking(String message) {
        super(message);
    }
}
