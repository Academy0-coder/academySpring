package com.vlc2.academy.cinema.service.impl;

import com.vlc2.academy.cinema.entity.Movie;
import com.vlc2.academy.cinema.dto.MovieDTO;
import com.vlc2.academy.cinema.exception.MovieNotFound;
import com.vlc2.academy.cinema.mapper.MovieMapper;
import com.vlc2.academy.cinema.repository.MovieRepository;
import com.vlc2.academy.cinema.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;
    MovieMapper movieMapper;

    @Override
    public MovieDTO save(MovieDTO request) {
        Movie save = movieMapper.toEntity(request);
        movieRepository.save(save);

        Movie movie = movieRepository.findLast().get();
        MovieDTO response = movieMapper.toDto(movie);
        return response;
    }

    @Override
    public List<MovieDTO> findAll() {
        List<Movie> movies = movieRepository.findAll();
        List<MovieDTO> response = movieMapper.listToDto(movies);
        return response;
    }

    @Override
    public MovieDTO findById(Integer id)  {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFound(String.format("There's no movie with id %d",id)));
        MovieDTO response = movieMapper.toDto(movie);
        return response;
    }

}