package com.vlc2.academy.cinema.controller.impl;

import com.vlc2.academy.cinema.command.ShowCommand;
import com.vlc2.academy.cinema.controller.ShowController;
import com.vlc2.academy.cinema.dto.ShowDTO;
import com.vlc2.academy.cinema.service.ShowService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class ShowControllerImpl implements ShowController {

    private ShowService showService;
    private BeanFactory beanFactory;

    @PostMapping("/movie_shows")
    public ResponseEntity<ShowDTO> saveShow(@RequestBody ShowDTO request){
        ShowCommand showCommand = beanFactory.getBean(ShowCommand.class, showService, request);
        return ResponseEntity.ok(showCommand.execute());
    }

    @GetMapping("/movie_shows")
    public ResponseEntity<List<ShowDTO>> getAllShows() {
        return ResponseEntity.ok(showService.findAll());
    }

    @GetMapping("/movie_shows/{id}")
    public ResponseEntity<ShowDTO> getShowById(@PathVariable Integer id) {
        return ResponseEntity.ok(showService.findById(id));
    }
}