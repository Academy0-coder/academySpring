package com.vlc2.academy.negozio.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {

    private String errorCode;
    private String errorMessage;

}
