package com.vlc2.academy.cinema.controller;

import com.vlc2.academy.cinema.command.WatcherCommand;
import com.vlc2.academy.cinema.dto.WatcherDTO;
import com.vlc2.academy.cinema.dto.request.WatcherCreate;
import com.vlc2.academy.cinema.service.WatcherService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController()
public class WatcherController {

    private WatcherService watcherService;
    private BeanFactory beanFactory;

    @PostMapping("/watchers")
    public ResponseEntity<WatcherDTO> saveWatcher(@RequestBody WatcherCreate request){
        WatcherCommand watcherCommand = beanFactory.getBean(WatcherCommand.class, watcherService, request);
        return ResponseEntity.ok(watcherCommand.execute());
    }

    @GetMapping("/watchers")
    public ResponseEntity<List<WatcherDTO>> getAllWatchers() {
        return ResponseEntity.ok(watcherService.findAll());
    }

    @GetMapping("/watchers/{id}")
    public ResponseEntity<WatcherDTO> getWatcherById(@PathVariable Integer id) {
        return ResponseEntity.ok(watcherService.findById(id));
    }
}
