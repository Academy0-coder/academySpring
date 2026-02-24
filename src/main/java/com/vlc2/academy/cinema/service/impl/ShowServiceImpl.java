package com.vlc2.academy.cinema.service.impl;

import com.vlc2.academy.cinema.dto.request.ShowCreate;
import com.vlc2.academy.cinema.dto.request.ShowRead;
import com.vlc2.academy.cinema.entity.Movie;
import com.vlc2.academy.cinema.entity.Show;
import com.vlc2.academy.cinema.dto.ShowDTO;
import com.vlc2.academy.cinema.entity.Theater;
import com.vlc2.academy.cinema.exception.customs.*;
import com.vlc2.academy.cinema.mapper.ShowMapper;
import com.vlc2.academy.cinema.repository.MovieRepository;
import com.vlc2.academy.cinema.repository.ShowRepository;
import com.vlc2.academy.cinema.repository.TheaterRepository;
import com.vlc2.academy.cinema.service.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ShowServiceImpl implements ShowService {

    ShowRepository showRepository;
    ShowMapper showMapper;
    MovieRepository movieRepository;
    TheaterRepository theaterRepository;

    @Override
    public ShowRead save(ShowCreate request) {


        Movie movie = movieRepository.findById(request.getMovieId())
                .orElseThrow(()-> new MovieNotFound("There's no movie with id: "+request.getMovieId()));

        Theater theater = theaterRepository.findById(request.getTheaterId())
                .orElseThrow(()-> new TheaterNotFound("There's no theater with id: "+request.getTheaterId()));

        Optional<Show> lastShow = showRepository.findFirstByTheaterAndBeginOrderByBeginDesc(theater, request.getBegin());

        if(lastShow.isPresent())
            if(lastShow.get()
                        .getEnd().isAfter(request.getBegin())){
            throw new InvalidTime(String.format("You can't insert a show at %s in %s because %s finishes at %s",
                    request.getBegin(),
                    theater.getName(),
                    lastShow.get().getMovie().getName(),
                    lastShow.get().getEnd()));
        }


        ShowDTO mapped = new ShowDTO(theater.getSeats(),
                request.getBegin(),
                request.getBegin().plusMinutes(movie.getLength()),
                theater,
                movie);


        Show save = showMapper.toEntity(mapped);
        showRepository.save(save);


        Show show = showRepository.findLast().get();
        ShowRead response = showMapper.read(showMapper.toDto(show));
        return response;
    }

    @Override
    public List<ShowRead> findAll() {

        if(!showRepository.isPresent()){
            throw new EmptyListException("There are no shows in the database");
        }

        List<Show> shows = showRepository.findAll();
        List<ShowDTO> dto = showMapper.listToDto(shows);
        List<ShowRead> response = showMapper.read(dto);
        return response;
    }

    @Override
    public ShowRead findById(Integer id)  {
        Show show = showRepository.findById(id)
                .orElseThrow(() -> new ShowNotFound(String.format("There's no show with id %d",id)));
        ShowDTO dto = showMapper.toDto(show);
        ShowRead response = showMapper.read(dto);
        return response;
    }

}