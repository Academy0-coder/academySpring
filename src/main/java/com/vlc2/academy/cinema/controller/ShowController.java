package com.vlc2.academy.cinema.controller;

import com.vlc2.academy.cinema.command.ShowCommand;
import com.vlc2.academy.cinema.dto.request.ShowCreate;
import com.vlc2.academy.cinema.dto.request.ShowRead;
import com.vlc2.academy.cinema.service.ShowService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Tag(name = "Shows")
@RestController()
public class ShowController {

    private ShowService showService;
    private BeanFactory beanFactory;

    @PostMapping("/movie_shows")
    @Operation(summary = "Insert a new show", description = "Fields required are: starting time, movie id and theater id")
    public ResponseEntity<ShowRead> saveShow(@RequestBody ShowCreate request){
        ShowCommand showCommand = beanFactory.getBean(ShowCommand.class, showService, request);
        return ResponseEntity.ok(showCommand.execute());
    }

    @GetMapping("/movie_shows")
    @Operation(summary = "Get all shows")
    public ResponseEntity<List<ShowRead>> getAllShows() {
        return ResponseEntity.ok(showService.findAll());
    }

    @GetMapping("/movie_shows/{id}")
    @Operation(summary = "Find a show", description = "Find a show by id")
    public ResponseEntity<ShowRead> getShowById(@PathVariable Integer id) {
        return ResponseEntity.ok(showService.findById(id));
    }
}