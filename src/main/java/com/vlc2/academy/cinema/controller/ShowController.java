package com.vlc2.academy.cinema.controller;

import com.vlc2.academy.cinema.dto.ShowDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShowController {

    // POST REQUEST
    // save a new show
    ResponseEntity<ShowDTO> saveShow(ShowDTO request);

    // GET REQUEST
    // get all shows
    ResponseEntity<List<ShowDTO>> getAllShows ();

    // get a show by id
    ResponseEntity<ShowDTO> getShowById (Integer id);

}
