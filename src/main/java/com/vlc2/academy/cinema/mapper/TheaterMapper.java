package com.vlc2.academy.cinema.mapper;

import com.vlc2.academy.cinema.dto.request.TheaterCreate;
import com.vlc2.academy.cinema.entity.Theater;
import com.vlc2.academy.cinema.dto.TheaterDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TheaterMapper {

    Theater toEntity (TheaterDTO theaterDTO);

    TheaterDTO toDto (Theater theater);

    TheaterDTO toDto (TheaterCreate theaterCreate);

    List<TheaterDTO> listToDto (List<Theater> theaters);
}