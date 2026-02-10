package com.vlc2.academy.negozio.command;

import com.vlc2.academy.negozio.dto.customer.CustomerCreateDTO;
import com.vlc2.academy.negozio.service.CustomerService;
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
public class CustomerCommand {
    private final CustomerService customerService;
    private final CustomerCreateDTO dto;

    public void execute(){
        if (canExecute()){
            doExecute();
        }
    }

    private boolean canExecute(){
        return !((dto.getName() == null || dto.getName().isBlank())
                || (dto.getSurname() == null || dto.getSurname().isBlank()));
    }

    private void doExecute(){
        customerService.createUser(dto);
    }

}
