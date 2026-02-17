package com.vlc2.academy.cinema.mapper;

import com.vlc2.academy.cinema.entity.Movie;
import com.vlc2.academy.cinema.dto.MovieDTO;
import org.mapstruct.Mappings;

import java.util.List;

@org.mapstruct.Mapper
public interface MovieMapper {

    // @Mappings()
    Movie toEntity (MovieDTO movieDTO);

    MovieDTO toDto (Movie movie);

    List<MovieDTO> listToDto (List<Movie> movies);
}