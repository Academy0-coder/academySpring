package com.vlc2.academy.negozio.exceptions.customExceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomerNotFound extends RuntimeException {

    public CustomerNotFound(String message) {
        super(message);
    }
}
