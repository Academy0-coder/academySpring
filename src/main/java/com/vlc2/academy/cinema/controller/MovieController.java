package com.vlc2.academy.cinema.controller;

import com.vlc2.academy.cinema.dto.MovieDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MovieController {

    // POST REQUEST
    // save a new movie
    ResponseEntity<MovieDTO> saveMovie(MovieDTO request);

    // GET REQUEST
    // get all movies
    ResponseEntity<List<MovieDTO>> getAllMovies ();

    // get a movie by id
    ResponseEntity<MovieDTO> getMovieById (Integer id);

}
