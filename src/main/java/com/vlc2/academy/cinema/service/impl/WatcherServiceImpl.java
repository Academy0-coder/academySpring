package com.vlc2.academy.cinema.service.impl;

import com.vlc2.academy.cinema.entity.Watcher;
import com.vlc2.academy.cinema.dto.WatcherDTO;
import com.vlc2.academy.cinema.exception.WatcherNotFound;
import com.vlc2.academy.cinema.mapper.WatcherMapper;
import com.vlc2.academy.cinema.repository.WatcherRepository;
import com.vlc2.academy.cinema.service.WatcherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatcherServiceImpl implements WatcherService {

    WatcherRepository watcherRepository;
    WatcherMapper watcherMapper;

    @Override
    public WatcherDTO save(WatcherDTO request) {
        Watcher save = watcherMapper.toEntity(request);
        watcherRepository.save(save);

        Watcher watcher = watcherRepository.findLast().get();
        WatcherDTO response = watcherMapper.toDto(watcher);
        return response;
    }

    @Override
    public List<WatcherDTO> findAll() {
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
