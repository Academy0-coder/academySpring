package com.vlc2.academy.cinema.controller;

import com.vlc2.academy.cinema.dto.WatcherDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WatcherController {

    // POST REQUEST
    // save a new watcher
    ResponseEntity<WatcherDTO> saveWatcher(WatcherDTO request);

    // GET REQUEST
    // get all watchers
    ResponseEntity<List<WatcherDTO>> getAllWatchers ();

    // get a watcher by id
    ResponseEntity<WatcherDTO> getWatcherById (Integer id);

}
