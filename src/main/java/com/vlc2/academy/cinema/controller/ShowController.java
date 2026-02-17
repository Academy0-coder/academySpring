package com.vlc2.academy.cinema.controller;

import com.vlc2.academy.cinema.command.ShowCommand;
import com.vlc2.academy.cinema.dto.ShowDTO;
import com.vlc2.academy.cinema.dto.request.ShowCreate;
import com.vlc2.academy.cinema.dto.request.ShowRead;
import com.vlc2.academy.cinema.service.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController()
public class ShowController {

    private ShowService showService;
    private BeanFactory beanFactory;

    @PostMapping("/movie_shows")
    public ResponseEntity<ShowRead> saveShow(@RequestBody ShowCreate request){
        ShowCommand showCommand = beanFactory.getBean(ShowCommand.class, showService, request);
        return ResponseEntity.ok(showCommand.execute());
    }

    @GetMapping("/movie_shows")
    public ResponseEntity<List<ShowRead>> getAllShows() {
        return ResponseEntity.ok(showService.findAll());
    }

    @GetMapping("/movie_shows/{id}")
    public ResponseEntity<ShowRead> getShowById(@PathVariable Integer id) {
        return ResponseEntity.ok(showService.findById(id));
    }
}