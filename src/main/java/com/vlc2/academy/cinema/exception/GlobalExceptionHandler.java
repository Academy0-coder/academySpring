package com.vlc2.academy.cinema.exception;

import com.vlc2.academy.cinema.exception.customs.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages = "com.vlc2.academy.cinema")
public class GlobalExceptionHandler {

    @ExceptionHandler(EmptyListException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponseCinema handleEmptyList (EmptyListException exc){
        return new ErrorResponseCinema("EMPTY_LIST_EXCEPTION",exc.getMessage());
    }

    @ExceptionHandler(InputInvalid.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponseCinema handleInputInvalid (InputInvalid exc){
        return new ErrorResponseCinema("INPUT_INVALID_EXCEPTION",exc.getMessage());
    }

    @ExceptionHandler(WatcherNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponseCinema handleWatcherNotFound (WatcherNotFound exc){
        return new ErrorResponseCinema("WATCHER_NOT_FOUND",exc.getMessage());
    }

    @ExceptionHandler(MovieNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponseCinema handleMovieNotFound (MovieNotFound exc){
        return new ErrorResponseCinema("MOVIE_NOT_FOUND",exc.getMessage());
    }

    @ExceptionHandler(ShowNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponseCinema handleShowNotFound (ShowNotFound exc){
        return new ErrorResponseCinema("SHOW_NOT_FOUND",exc.getMessage());
    }

    @ExceptionHandler(TicketNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponseCinema handleTicketNotFound (TicketNotFound exc){
        return new ErrorResponseCinema("TICKET_NOT_FOUND",exc.getMessage());
    }

    @ExceptionHandler(TheaterNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponseCinema handleTheaterNotFound (TheaterNotFound exc){
        return new ErrorResponseCinema("THEATER_NOT_FOUND",exc.getMessage());
    }

    @ExceptionHandler(InvalidBooking.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponseCinema handleInvalidBooking (InvalidBooking exc){
        return new ErrorResponseCinema("INVALID_BOOKING",exc.getMessage());
    }

    @ExceptionHandler(InvalidTime.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponseCinema handleInvalidTime (InvalidTime exc){
        return new ErrorResponseCinema("INVALID_TIME",exc.getMessage());
    }


}
