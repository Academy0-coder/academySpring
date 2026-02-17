package com.vlc2.academy.cinema.exception.customs;

public class MovieNotFound extends NullPointerException {
    public MovieNotFound(String message) {
        super(message);
    }
}
