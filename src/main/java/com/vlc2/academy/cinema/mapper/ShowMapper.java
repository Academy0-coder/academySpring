package com.vlc2.academy.cinema.mapper;

import com.vlc2.academy.cinema.entity.Show;
import com.vlc2.academy.cinema.dto.ShowDTO;

import java.util.List;

@org.mapstruct.Mapper
public interface ShowMapper {

    Show toEntity (ShowDTO showDTO);

    ShowDTO toDto (Show show);

    List<ShowDTO> listToDto (List<Show> shows);
}