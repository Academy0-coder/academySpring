package com.vlc2.academy.cinema.command;

import com.vlc2.academy.cinema.dto.ShowDTO;
import com.vlc2.academy.cinema.exception.ShowNotFound;
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
    private ShowDTO request;

    public ShowDTO execute(){
        if (canExecute()){
            return doExecute();
        }
        throw new ShowNotFound("Invalid arguments: name and surname can't be empty");
    }

    private boolean canExecute(){
        return !((request.getBegin() == null
                || request.getBegin().isBefore(LocalDateTime.now().minusMonths(3))
                || request.getBegin().isAfter(LocalDateTime.now().plusYears(1)))
                || (request.getMovie() == null))
                || (request.getTheater() == null);
    }

    private ShowDTO doExecute(){
        return showService.save(request);
    }

}