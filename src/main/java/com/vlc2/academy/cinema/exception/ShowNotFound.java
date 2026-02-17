package com.vlc2.academy.cinema.exception;

public class ShowNotFound extends IllegalArgumentException {
    public ShowNotFound(String message) {
        super(message);
    }
}
