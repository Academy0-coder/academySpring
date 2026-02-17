package com.vlc2.academy.cinema.exception.customs;

public class TicketNotFound extends NullPointerException {
    public TicketNotFound(String message) {
        super(message);
    }
}
