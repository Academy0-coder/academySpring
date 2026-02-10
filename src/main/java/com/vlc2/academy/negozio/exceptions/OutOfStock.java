package com.vlc2.academy.negozio.exceptions;

public class OutOfStock extends RuntimeException {
    public OutOfStock(String message) {
        super(message);
    }
}
