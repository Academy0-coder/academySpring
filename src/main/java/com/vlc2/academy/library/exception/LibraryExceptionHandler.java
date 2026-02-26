package com.vlc2.academy.library.exception;

import com.vlc2.academy.cinema.exception.customs.EmptyListException;
import com.vlc2.academy.library.exception.custom.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages = "com.vlc2.academy.library")
public class LibraryExceptionHandler {

    @ExceptionHandler(InvalidEditorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponseLibrary handleInvalidEditor (InvalidEditorException exc){
        return new ErrorResponseLibrary("INVALID_EDITOR_EXCEPTION",exc.getMessage());
    }

    @ExceptionHandler(InvalidEmailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponseLibrary handleInvalidEmail (InvalidEmailException exc){
        return new ErrorResponseLibrary("INVALID_EMAIL_EXCEPTION",exc.getMessage());
    }

    @ExceptionHandler(NullInsertException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponseLibrary handleNullInsert (NullInsertException exc){
        return new ErrorResponseLibrary("NULL_INSERT_EXCEPTION",exc.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponseLibrary handleEntityNotFound (EntityNotFoundException exc){
        return new ErrorResponseLibrary("ENTITY_NOT_FOUND",exc.getMessage());
    }

    @ExceptionHandler(InvalidYearException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponseLibrary handleInvalidYear (InvalidYearException exc){
        return new ErrorResponseLibrary("INVALID_YEAR",exc.getMessage());
    }

    @ExceptionHandler(InvalidQuantityException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponseLibrary handleInvalidQuantity (InvalidQuantityException exc){
        return new ErrorResponseLibrary("INVALID_QUANTITY",exc.getMessage());
    }

    @ExceptionHandler(InvalidPriceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponseLibrary handleInvalidPrice (InvalidPriceException exc){
        return new ErrorResponseLibrary("INVALID_PRICE",exc.getMessage());
    }

    @ExceptionHandler(InvalidBookException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponseLibrary handleInvalidBook (InvalidBookException exc){
        return new ErrorResponseLibrary("INVALID_BOOK_EXCEPTION",exc.getMessage());
    }

    @ExceptionHandler(InvalidDateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponseLibrary handleInvalidDate (InvalidDateException exc){
        return new ErrorResponseLibrary("INVALID_DATE_EXCEPTION",exc.getMessage());
    }

    @ExceptionHandler(SoldOutException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponseLibrary handleSoldOut (SoldOutException exc){
        return new ErrorResponseLibrary("SOLD_OUT_EXCEPTION",exc.getMessage());
    }

    @ExceptionHandler(InvalidOrderException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponseLibrary handleInvalidOrder (InvalidOrderException exc){
        return new ErrorResponseLibrary("INVALID_ORDER_EXCEPTION",exc.getMessage());
    }

}
