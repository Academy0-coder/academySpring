package com.vlc2.academy.cinema.command;

import com.vlc2.academy.cinema.dto.ShowDTO;
import com.vlc2.academy.cinema.dto.request.ShowCreate;
import com.vlc2.academy.cinema.dto.request.ShowRead;
import com.vlc2.academy.cinema.exception.customs.InputInvalid;
import com.vlc2.academy.cinema.exception.customs.ShowNotFound;
import com.vlc2.academy.cinema.service.ShowService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Getter
@Setter
@RequiredArgsConstructor
public class ShowCommand {

    private final ShowService showService;
    private final ShowCreate request;

    public ShowRead execute(){
        if (canExecute()){
            return doExecute();
        }
        throw new InputInvalid("Invalid arguments: fields can't be empty and time must be between 1 month before now and 3 months after now");
    }

    private boolean canExecute(){
        return !((request.getBegin() == null
                || request.getBegin().isBefore(LocalDateTime.now().minusMonths(3))
                || request.getBegin().isAfter(LocalDateTime.now().plusYears(1)))
                || (request.getMovieId() == null || request.getMovieId() <= 0)
                || (request.getTheaterId() == null || request.getTheaterId() <= 0));
    }

    private ShowRead doExecute(){
        return showService.save(request);
    }

}