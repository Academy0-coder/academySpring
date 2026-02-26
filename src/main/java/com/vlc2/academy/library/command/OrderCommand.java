package com.vlc2.academy.library.command;

import com.vlc2.academy.library.dto.request.OrderRequest;
import com.vlc2.academy.library.dto.response.OrderResponse;
import com.vlc2.academy.library.exception.custom.InvalidDateException;
import com.vlc2.academy.library.exception.custom.InvalidOrderException;
import com.vlc2.academy.library.service.OrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Getter
@RequiredArgsConstructor
public class OrderCommand {

    private final OrderService service;
    private final OrderRequest request;

    public OrderResponse execute() {
        validate();
        return service.confirmOrder(request);
    }

    public void validate(){

        if(request.getId() == null || request.getId() < 1){
            throw new InvalidOrderException("You must provide a positive integer");
        }
        if(!service.existsById(request.getId())){
            throw new InvalidOrderException(String.format("There's no order with id: %d",request));
        }
        if(request.getDate() == null){
            throw new InvalidDateException("You must provide a date");
        }
        if(request.getDate().isBefore(service.getDayOrder(request.getId()))){
            throw new InvalidDateException("You can't resolve an order before it was requested");
        }

    }
}
