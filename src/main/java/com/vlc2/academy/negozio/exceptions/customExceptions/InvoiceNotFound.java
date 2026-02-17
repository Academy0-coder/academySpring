package com.vlc2.academy.negozio.exceptions.customExceptions;

public class InvoiceNotFound extends RuntimeException {
    public InvoiceNotFound(String message) {
        super(message);
    }
}
