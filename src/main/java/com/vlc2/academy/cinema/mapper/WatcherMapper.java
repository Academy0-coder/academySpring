package com.vlc2.academy.cinema.mapper;

import com.vlc2.academy.cinema.entity.Watcher;
import com.vlc2.academy.cinema.dto.WatcherDTO;

import java.util.List;

@org.mapstruct.Mapper
public interface WatcherMapper {

    Watcher toEntity (WatcherDTO watcherDTO);

    WatcherDTO toDto (Watcher watcher);

    List<WatcherDTO> listToDto (List<Watcher> watchers);
}
