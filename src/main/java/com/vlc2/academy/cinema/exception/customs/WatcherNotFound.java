package com.vlc2.academy.cinema.exception.customs;

public class WatcherNotFound extends NullPointerException {
    public WatcherNotFound(String message) {
        super(message);
    }
}
