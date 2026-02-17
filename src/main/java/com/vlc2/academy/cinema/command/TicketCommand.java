package com.vlc2.academy.cinema.command;

import com.vlc2.academy.cinema.dto.TicketDTO;
import com.vlc2.academy.cinema.exception.TicketNotFound;
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
    private TicketDTO request;

    public TicketDTO execute(){
        if (canExecute()){
            return doExecute();
        }
        throw new TicketNotFound("Invalid arguments: name and surname can't be empty");
    }

    private boolean canExecute(){
        return !((request.getShow() == null)
                || (request.getWatcher() == null)
                || (request.getSeatNumber() == null || request.getSeatNumber() <= 0 || request.getSeatNumber() > request.getShow().getTheater().getSeats())
                || (request.getWatcher() == null));
    }

    private TicketDTO doExecute(){
        return ticketService.save(request);
    }

}