package com.vlc2.academy.cinema.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorResponseCinema {

    private String errorCode;
    private String errorMessage;

}