package com.vlc2.academy.negozio.command;

import com.vlc2.academy.negozio.dto.customer.CustomerDeleteDTO;
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
public class CustomerDeleteCommand {
    private final CustomerService customerService;
    private final CustomerDeleteDTO customerDeleteDTO;

    public CustomerReadDTO execute(){
        if (canExecute()){
            return doExecute();
        }
        return null;
    }

    private boolean canExecute(){
        return !(customerDeleteDTO.getId() == null || customerDeleteDTO.getId() <= 0);
    }

    private CustomerReadDTO doExecute(){
        return customerService.deleteUser(customerDeleteDTO);
    }
}
