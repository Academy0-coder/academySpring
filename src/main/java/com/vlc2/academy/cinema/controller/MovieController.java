package com.vlc2.academy.cinema.controller;

import com.vlc2.academy.cinema.command.MovieCommand;
import com.vlc2.academy.cinema.dto.MovieDTO;
import com.vlc2.academy.cinema.dto.request.MovieCreate;
import com.vlc2.academy.cinema.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController()
public class MovieController {

    private MovieService movieService;
    private BeanFactory beanFactory;

    @PostMapping("/movies")
    public ResponseEntity<MovieDTO> saveMovie(@RequestBody MovieCreate request){
        MovieCommand movieCommand = beanFactory.getBean(MovieCommand.class, movieService, request);
        return ResponseEntity.ok(movieCommand.execute());
    }

    @GetMapping("/movies")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        return ResponseEntity.ok(movieService.findAll());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.findById(id));
    }
}