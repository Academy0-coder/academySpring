package com.vlc2.academy.cinema.service;

import com.vlc2.academy.cinema.dto.WatcherDTO;
import com.vlc2.academy.cinema.dto.request.WatcherCreate;

import java.util.List;

public interface WatcherService {

    // CREATE
    // Save a new watcher
    WatcherDTO save(WatcherCreate watcherRequest);

    // READ
    // Find all watchers
    List<WatcherDTO> findAll();
    // Find a watcher by id
    WatcherDTO findById(Integer id);
}
