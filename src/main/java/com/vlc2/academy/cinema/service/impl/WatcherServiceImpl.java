package com.vlc2.academy.cinema.service.impl;

import com.vlc2.academy.cinema.dto.request.WatcherCreate;
import com.vlc2.academy.cinema.entity.Watcher;
import com.vlc2.academy.cinema.dto.WatcherDTO;
import com.vlc2.academy.cinema.entity.other.Membership;
import com.vlc2.academy.cinema.exception.customs.EmptyListException;
import com.vlc2.academy.cinema.exception.customs.WatcherNotFound;
import com.vlc2.academy.cinema.mapper.WatcherMapper;
import com.vlc2.academy.cinema.repository.WatcherRepository;
import com.vlc2.academy.cinema.service.WatcherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class WatcherServiceImpl implements WatcherService {

    WatcherRepository watcherRepository;
    WatcherMapper watcherMapper;

    @Override
    public WatcherDTO save(WatcherCreate request) {

        WatcherDTO mapped = new WatcherDTO(request.getName(),
                request.getSurname(),
                0,
                Membership.BRONZE);

        Watcher save = watcherMapper.toEntity(mapped);
        watcherRepository.save(save);

        Watcher watcher = watcherRepository.findLast().get();
        WatcherDTO response = watcherMapper.toDto(watcher);
        return response;
    }

    @Override
    public List<WatcherDTO> findAll() {

        if(!watcherRepository.isPresent()){
            throw new EmptyListException("There are no watchers in the database");
        }

        List<Watcher> watchers = watcherRepository.findAll();
        List<WatcherDTO> response = watcherMapper.listToDto(watchers);
        return response;
    }

    @Override
    public WatcherDTO findById(Integer id)  {
        Watcher watcher = watcherRepository.findById(id)
                .orElseThrow(() -> new WatcherNotFound(String.format("There's no watcher with id %d",id)));
        WatcherDTO response = watcherMapper.toDto(watcher);
        return response;
    }

}
