package com.vlc2.academy.cinema.exception;

public class WatcherNotFound extends IllegalArgumentException {
    public WatcherNotFound(String message) {
        super(message);
    }
}
