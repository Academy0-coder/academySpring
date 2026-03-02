package com.vlc2.academy.library.populating;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/populating")
@ConditionalOnProperty(name = "populate", havingValue = "true")
@RequiredArgsConstructor
public class PopulatingController {

    private final PopulatingService populatingService;

    @GetMapping()
    public void populate() {
        populatingService.populate();
    }

}
