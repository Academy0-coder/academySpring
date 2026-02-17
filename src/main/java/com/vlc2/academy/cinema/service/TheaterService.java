package com.vlc2.academy.cinema.service;

import com.vlc2.academy.cinema.dto.TheaterDTO;

import java.util.List;

public interface TheaterService {

    // CREATE
    // Save a new theater
    TheaterDTO save(TheaterDTO theaterRequest);

    // READ
    // Find all theaters
    List<TheaterDTO> findAll();
    // Find a theater by id
    TheaterDTO findById(Integer id);
}

