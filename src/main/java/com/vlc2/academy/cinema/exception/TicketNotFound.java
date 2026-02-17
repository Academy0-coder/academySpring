package com.vlc2.academy.cinema.exception;

public class TicketNotFound extends IllegalArgumentException {
    public TicketNotFound(String message) {
        super(message);
    }
}
