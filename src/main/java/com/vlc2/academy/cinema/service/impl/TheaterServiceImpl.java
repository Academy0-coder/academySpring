package com.vlc2.academy.cinema.service.impl;

import com.vlc2.academy.cinema.entity.Theater;
import com.vlc2.academy.cinema.dto.TheaterDTO;
import com.vlc2.academy.cinema.exception.TheaterNotFound;
import com.vlc2.academy.cinema.mapper.TheaterMapper;
import com.vlc2.academy.cinema.repository.TheaterRepository;
import com.vlc2.academy.cinema.service.TheaterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterServiceImpl implements TheaterService {

    TheaterRepository theaterRepository;
    TheaterMapper theaterMapper;

    @Override
    public TheaterDTO save(TheaterDTO request) {
        Theater save = theaterMapper.toEntity(request);
        theaterRepository.save(save);

        Theater theater = theaterRepository.findLast().get();
        TheaterDTO response = theaterMapper.toDto(theater);
        return response;
    }

    @Override
    public List<TheaterDTO> findAll() {
        List<Theater> theaters = theaterRepository.findAll();
        List<TheaterDTO> response = theaterMapper.listToDto(theaters);
        return response;
    }

    @Override
    public TheaterDTO findById(Integer id)  {
        Theater theater = theaterRepository.findById(id)
                .orElseThrow(() -> new TheaterNotFound(String.format("There's no theater with id %d",id)));
        TheaterDTO response = theaterMapper.toDto(theater);
        return response;
    }

}