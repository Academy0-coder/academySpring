package com.vlc2.academy.cinema.mapper;

import com.vlc2.academy.cinema.entity.Watcher;
import com.vlc2.academy.cinema.dto.WatcherDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WatcherMapper {

    Watcher toEntity (WatcherDTO watcherDTO);

    WatcherDTO toDto (Watcher watcher);

    List<WatcherDTO> listToDto (List<Watcher> watchers);
}
