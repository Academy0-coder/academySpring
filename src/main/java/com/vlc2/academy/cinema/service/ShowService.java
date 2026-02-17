package com.vlc2.academy.cinema.service;

import com.vlc2.academy.cinema.dto.ShowDTO;

import java.util.List;

public interface ShowService {

    // CREATE
    // Save a new show
    ShowDTO save(ShowDTO showRequest);

    // READ
    // Find all shows
    List<ShowDTO> findAll();
    // Find a show by id
    ShowDTO findById(Integer id);
}


