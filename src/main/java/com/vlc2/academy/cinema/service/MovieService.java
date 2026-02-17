package com.vlc2.academy.cinema.service;

import com.vlc2.academy.cinema.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    // CREATE
    // Save a new movie
    MovieDTO save(MovieDTO movieRequest);

    // READ
    // Find all movies
    List<MovieDTO> findAll();
    // Find a movie by id
    MovieDTO findById(Integer id);
}



