package com.vlc2.academy.negozio.exceptions.customExceptions;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound(String message) {
        super(message);
    }
}
