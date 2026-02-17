package com.vlc2.academy.cinema.command;

import com.vlc2.academy.cinema.dto.MovieDTO;
import com.vlc2.academy.cinema.dto.request.MovieCreate;
import com.vlc2.academy.cinema.exception.customs.MovieNotFound;
import com.vlc2.academy.cinema.service.MovieService;
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
public class MovieCommand {

    private final MovieService movieService;
    private final MovieCreate request;

    public MovieDTO execute(){
        if (canExecute()){
            return doExecute();
        }
        throw new MovieNotFound("Invalid arguments: name and surname can't be empty");
    }

    private boolean canExecute(){
        return !((request.getName() == null || request.getName().isBlank())
                || (request.getDirectorName() == null || request.getDirectorName().isBlank())
                || (request.getPrice() == null || request.getPrice() <= 0)
                || (request.getRating() == null || request.getRating() <1 || request.getRating() >5)
                || (request.getGenre() == null));
    }

    private MovieDTO doExecute(){
        return movieService.save(request);
    }

}