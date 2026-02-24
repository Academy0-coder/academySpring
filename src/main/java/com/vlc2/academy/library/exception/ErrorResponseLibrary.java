package com.vlc2.academy.library.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorResponseLibrary {

    private String errorCode;
    private String errorMessage;

}
