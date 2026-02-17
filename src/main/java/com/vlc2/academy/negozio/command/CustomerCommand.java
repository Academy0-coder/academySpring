package com.vlc2.academy.negozio.command;

import com.vlc2.academy.negozio.dto.customer.CustomerCreateDTO;
import com.vlc2.academy.negozio.dto.customer.CustomerReadDTO;
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
    private CustomerCreateDTO customerCreateDTO;

    public CustomerReadDTO execute(){
        if (canExecute()){
            return doExecute();
        }
        if(customerCreateDTO.getName() == null || customerCreateDTO.getSurname() == null){
            throw new NullPointerException("Name and surname can't be null");
        }
        throw new IllegalArgumentException("Name and surname can't be empty");
    }

    private boolean canExecute(){
        System.out.println("log");
        return !((customerCreateDTO.getName() == null || customerCreateDTO.getName().isBlank())
                || (customerCreateDTO.getSurname() == null || customerCreateDTO.getSurname().isBlank()));
    }

    private CustomerReadDTO doExecute(){
        return customerService.createUser(customerCreateDTO);
    }

}
