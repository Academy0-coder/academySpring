package com.vlc2.academy.cinema.command;

import com.vlc2.academy.cinema.dto.WatcherDTO;
import com.vlc2.academy.cinema.dto.request.WatcherCreate;
import com.vlc2.academy.cinema.exception.customs.InputInvalid;
import com.vlc2.academy.cinema.exception.customs.WatcherNotFound;
import com.vlc2.academy.cinema.service.WatcherService;
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
public class WatcherCommand {

    private final WatcherService watcherService;
    private final WatcherCreate request;

    public WatcherDTO execute(){
        if (canExecute()){
            return doExecute();
        }
        throw new InputInvalid("Invalid arguments: name and surname can't be empty");
    }

    private boolean canExecute(){
        return !((request.getName() == null || request.getName().isBlank())
                || (request.getSurname() == null || request.getSurname().isBlank()));
    }

    private WatcherDTO doExecute(){
        return watcherService.save(request);
    }

}
