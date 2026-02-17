package com.vlc2.academy.cinema.controller.impl;

import com.vlc2.academy.cinema.command.TheaterCommand;
import com.vlc2.academy.cinema.controller.TheaterController;
import com.vlc2.academy.cinema.dto.TheaterDTO;
import com.vlc2.academy.cinema.service.TheaterService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class TheaterControllerImpl implements TheaterController {

    private TheaterService theaterService;
    private BeanFactory beanFactory;

    @PostMapping("/theaters")
    public ResponseEntity<TheaterDTO> saveTheater(@RequestBody TheaterDTO request){
        TheaterCommand theaterCommand = beanFactory.getBean(TheaterCommand.class, theaterService, request);
        return ResponseEntity.ok(theaterCommand.execute());
    }

    @GetMapping("/theaters")
    public ResponseEntity<List<TheaterDTO>> getAllTheaters() {
        return ResponseEntity.ok(theaterService.findAll());
    }

    @GetMapping("/theaters/{id}")
    public ResponseEntity<TheaterDTO> getTheaterById(@PathVariable Integer id) {
        return ResponseEntity.ok(theaterService.findById(id));
    }
}