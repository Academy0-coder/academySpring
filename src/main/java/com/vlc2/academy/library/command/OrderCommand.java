package com.vlc2.academy.library.command;

import com.vlc2.academy.library.dto.response.OrderResponse;
import com.vlc2.academy.library.dto.response.SaleResponse;
import com.vlc2.academy.library.exception.custom.InvalidDateException;
import com.vlc2.academy.library.exception.custom.InvalidEditorException;
import com.vlc2.academy.library.exception.custom.InvalidOrderException;
import com.vlc2.academy.library.exception.custom.NullInsertException;
import com.vlc2.academy.library.service.OrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Getter
@RequiredArgsConstructor
public class OrderCommand {

    private final OrderService service;
    private final Integer request;

    public OrderResponse execute() {
        validate();
        return service.confirmOrder(request);
    }

    public void validate(){

        if(request == null || request < 1){
            throw new InvalidOrderException("You must provide a positive integer");
        }
        if(!service.existsById(request)){
            throw new InvalidOrderException(String.format("There's no order with id: %d",request));
        }

    }
}
