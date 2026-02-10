package com.vlc2.academy.negozio.controller.impl;

import com.vlc2.academy.negozio.command.CustomerCommand;
import com.vlc2.academy.negozio.controller.CustomerController;
import com.vlc2.academy.negozio.dto.customer.CustomerCreateDTO;
import com.vlc2.academy.negozio.dto.customer.CustomerReadDTO;
import com.vlc2.academy.negozio.service.CustomerService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class CustomerControllerImpl implements CustomerController {

    private CustomerService customerService;
    private BeanFactory beanFactory;

    public CustomerControllerImpl(CustomerService customerService, BeanFactory beanFactory){
        this.customerService = customerService;
        this.beanFactory = beanFactory;
    }

    @PostMapping("/customers")
    public ResponseEntity<Void> createUser(@RequestBody CustomerCreateDTO customerCreateDTO){
        CustomerCommand customerCommand = beanFactory.getBean(CustomerCommand.class, customerService, customerCreateDTO);
        customerCommand.execute();
        return ResponseEntity.ok(null);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerReadDTO>> getUsers(){

        return ResponseEntity.ok(customerService.getUsers());
    }
}
