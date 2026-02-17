package com.vlc2.academy.cinema.mapper;

import com.vlc2.academy.cinema.entity.Theater;
import com.vlc2.academy.cinema.dto.TheaterDTO;

import java.util.List;

@org.mapstruct.Mapper
public interface TheaterMapper {

    Theater toEntity (TheaterDTO theaterDTO);

    TheaterDTO toDto (Theater theater);

    List<TheaterDTO> listToDto (List<Theater> theaters);
}