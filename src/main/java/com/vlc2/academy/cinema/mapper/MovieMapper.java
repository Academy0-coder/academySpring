package com.vlc2.academy.cinema.mapper;

import com.vlc2.academy.cinema.dto.MovieDTO;
import com.vlc2.academy.cinema.dto.request.MovieCreate;
import com.vlc2.academy.cinema.entity.Movie;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface MovieMapper {

    // @Mappings()
    Movie toEntity (MovieDTO movieDTO);

    MovieDTO toDto (Movie movie);

    MovieDTO toDto (MovieCreate movieCreate);

    List<MovieDTO> listToDto (List<Movie> movies);
}