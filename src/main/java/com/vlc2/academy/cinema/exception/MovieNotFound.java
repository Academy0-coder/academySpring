package com.vlc2.academy.cinema.exception;

public class MovieNotFound extends IllegalArgumentException {
    public MovieNotFound(String message) {
        super(message);
    }
}
