package com.vlc2.academy.cinema.command;

import com.vlc2.academy.cinema.dto.TheaterDTO;
import com.vlc2.academy.cinema.dto.request.TheaterCreate;
import com.vlc2.academy.cinema.exception.customs.TheaterNotFound;
import com.vlc2.academy.cinema.service.TheaterService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Getter
@Setter
@RequiredArgsConstructor
public class TheaterCommand {

    private final TheaterService theaterService;
    private final TheaterCreate request;

    public TheaterDTO execute(){
        if (canExecute()){
            return doExecute();
        }
        throw new TheaterNotFound("Invalid arguments: name and surname can't be empty");
    }

    private boolean canExecute(){
        return !((request.getName() == null || request.getName().isBlank())
                || (request.getSeats() == null || request.getSeats() <= 0));
    }

    private TheaterDTO doExecute(){
        return theaterService.save(request);
    }

}