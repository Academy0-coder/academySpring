package com.vlc2.academy.cinema.controller;

import com.vlc2.academy.cinema.command.WatcherCommand;
import com.vlc2.academy.cinema.dto.WatcherDTO;
import com.vlc2.academy.cinema.dto.request.WatcherCreate;
import com.vlc2.academy.cinema.service.WatcherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Tag(name = "Watchers")
@RestController()
public class WatcherController {

    private WatcherService watcherService;
    private BeanFactory beanFactory;

    @PostMapping("/watchers")
    @Operation(summary = "Insert a new watcher", description = "Fields required are: name, surname")
    public ResponseEntity<WatcherDTO> saveWatcher(@RequestBody WatcherCreate request){
        WatcherCommand watcherCommand = beanFactory.getBean(WatcherCommand.class, watcherService, request);
        return ResponseEntity.ok(watcherCommand.execute());
    }

    @GetMapping("/watchers")
    @Operation(summary = "Get all watchers")
    public ResponseEntity<List<WatcherDTO>> getAllWatchers() {
        return ResponseEntity.ok(watcherService.findAll());
    }

    @GetMapping("/watchers/{id}")
    @Operation(summary = "Find a watcher", description = "Find a watcher by id")
    public ResponseEntity<WatcherDTO> getWatcherById(@PathVariable Integer id) {
        return ResponseEntity.ok(watcherService.findById(id));
    }
}
