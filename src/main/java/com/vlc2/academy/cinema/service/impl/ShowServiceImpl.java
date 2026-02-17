package com.vlc2.academy.cinema.service.impl;

import com.vlc2.academy.cinema.entity.Show;
import com.vlc2.academy.cinema.dto.ShowDTO;
import com.vlc2.academy.cinema.exception.ShowNotFound;
import com.vlc2.academy.cinema.mapper.ShowMapper;
import com.vlc2.academy.cinema.repository.ShowRepository;
import com.vlc2.academy.cinema.service.ShowService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    ShowRepository showRepository;
    ShowMapper showMapper;

    @Override
    public ShowDTO save(ShowDTO request) {
        Show save = showMapper.toEntity(request);
        showRepository.save(save);

        Show show = showRepository.findLast().get();
        ShowDTO response = showMapper.toDto(show);
        return response;
    }

    @Override
    public List<ShowDTO> findAll() {
        List<Show> shows = showRepository.findAll();
        List<ShowDTO> response = showMapper.listToDto(shows);
        return response;
    }

    @Override
    public ShowDTO findById(Integer id)  {
        Show show = showRepository.findById(id)
                .orElseThrow(() -> new ShowNotFound(String.format("There's no show with id %d",id)));
        ShowDTO response = showMapper.toDto(show);
        return response;
    }

}