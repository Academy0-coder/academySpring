package com.vlc2.academy.cinema.service;

import com.vlc2.academy.cinema.dto.TheaterDTO;
import com.vlc2.academy.cinema.dto.request.TheaterCreate;

import java.util.List;

public interface TheaterService {

    // CREATE
    // Save a new theater
    TheaterDTO save(TheaterCreate theaterRequest);

    // READ
    // Find all theaters
    List<TheaterDTO> findAll();
    // Find a theater by id
    TheaterDTO findById(Integer id);
}

