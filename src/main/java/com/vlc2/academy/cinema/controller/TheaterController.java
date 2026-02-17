package com.vlc2.academy.cinema.controller;

import com.vlc2.academy.cinema.dto.TheaterDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TheaterController {

    // POST REQUEST
    // save a new theater
    ResponseEntity<TheaterDTO> saveTheater(TheaterDTO request);

    // GET REQUEST
    // get all theaters
    ResponseEntity<List<TheaterDTO>> getAllTheaters ();

    // get a theater by id
    ResponseEntity<TheaterDTO> getTheaterById (Integer id);

}
