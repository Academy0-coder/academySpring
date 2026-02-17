package com.vlc2.academy.cinema.service;

import com.vlc2.academy.cinema.dto.ShowDTO;
import com.vlc2.academy.cinema.dto.request.ShowCreate;
import com.vlc2.academy.cinema.dto.request.ShowRead;

import java.util.List;

public interface ShowService {

    // CREATE
    // Save a new show
    ShowRead save(ShowCreate showRequest);

    // READ
    // Find all shows
    List<ShowRead> findAll();
    // Find a show by id
    ShowRead findById(Integer id);
}


