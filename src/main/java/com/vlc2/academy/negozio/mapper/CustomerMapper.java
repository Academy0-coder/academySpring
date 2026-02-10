package com.vlc2.academy.negozio.mapper;

import com.vlc2.academy.negozio.dto.customer.CustomerReadDTO;
import com.vlc2.academy.negozio.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerReadDTO toDTO(Customer customer){

        return new CustomerReadDTO(customer.getId(), customer.getName(), customer.getSurname());
    }

}
