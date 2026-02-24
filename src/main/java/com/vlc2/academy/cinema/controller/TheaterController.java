package com.vlc2.academy.cinema.controller;

import com.vlc2.academy.cinema.command.TheaterCommand;
import com.vlc2.academy.cinema.dto.TheaterDTO;
import com.vlc2.academy.cinema.dto.request.TheaterCreate;
import com.vlc2.academy.cinema.service.TheaterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Tag(name = "Theaters")
@RestController()
public class TheaterController {

    private TheaterService theaterService;
    private BeanFactory beanFactory;

    @PostMapping("/theaters")
    @Operation(summary = "Insert a new ticket", description = "Fields required are: name of the theater, number of seats")
    public ResponseEntity<TheaterDTO> saveTheater(@RequestBody TheaterCreate request){
        TheaterCommand theaterCommand = beanFactory.getBean(TheaterCommand.class, theaterService, request);
        return ResponseEntity.ok(theaterCommand.execute());
    }

    @GetMapping("/theaters")
    @Operation(summary = "Get all theaters")
    public ResponseEntity<List<TheaterDTO>> getAllTheaters() {
        return ResponseEntity.ok(theaterService.findAll());
    }

    @GetMapping("/theaters/{id}")
    @Operation(summary = "Find a theater", description = "Find a theater by id")
    public ResponseEntity<TheaterDTO> getTheaterById(@PathVariable Integer id) {
        return ResponseEntity.ok(theaterService.findById(id));
    }
}