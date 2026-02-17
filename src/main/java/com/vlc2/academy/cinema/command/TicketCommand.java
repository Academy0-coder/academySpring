package com.vlc2.academy.cinema.command;

import com.vlc2.academy.cinema.dto.TicketDTO;
import com.vlc2.academy.cinema.dto.request.TicketCreate;
import com.vlc2.academy.cinema.dto.request.TicketRead;
import com.vlc2.academy.cinema.exception.customs.InputInvalid;
import com.vlc2.academy.cinema.exception.customs.TicketNotFound;
import com.vlc2.academy.cinema.service.TicketService;
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
public class TicketCommand {

    private final TicketService ticketService;
    private final TicketCreate request;

    public TicketRead execute(){
        if (canExecute()){
            return doExecute();
        }
        throw new InputInvalid("Invalid arguments: fields can't be null and must be positive integers");
    }

    private boolean canExecute(){
        return !((request.getSeatNumber() == null || request.getSeatNumber() <= 0)
                || (request.getShowId() == null || request.getShowId() <= 0)
                || (request.getWatcherId() == null || request.getWatcherId() <= 0));
    }

    private TicketRead doExecute(){
        return ticketService.save(request);
    }

}