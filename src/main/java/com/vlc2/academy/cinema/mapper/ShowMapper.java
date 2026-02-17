package com.vlc2.academy.cinema.mapper;

import com.vlc2.academy.cinema.dto.ShowDTO;
import com.vlc2.academy.cinema.dto.request.ShowCreate;
import com.vlc2.academy.cinema.dto.request.ShowRead;
import com.vlc2.academy.cinema.entity.Show;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShowMapper {

    Show toEntity (ShowDTO showDTO);

    ShowDTO toDto (Show show);

    List<ShowDTO> listToDto (List<Show> shows);

    @Mapping(source = "theater.name", target = "theater")
    @Mapping(source = "movie.name", target = "movie")
    ShowRead read (ShowDTO show);

    @Mapping(source = "theater.name", target = "theater")
    @Mapping(source = "movie.name", target = "movie")
    List<ShowRead> read (List<ShowDTO> dto);

}