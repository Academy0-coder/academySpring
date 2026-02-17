package com.vlc2.academy.cinema.exception;

public class TheaterNotFound extends IllegalArgumentException {
    public TheaterNotFound(String message) {
        super(message);
    }
}
