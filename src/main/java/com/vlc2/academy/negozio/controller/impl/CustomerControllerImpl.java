package com.vlc2.academy.negozio.controller.impl;

import com.vlc2.academy.negozio.command.CustomerCreateCommand;
import com.vlc2.academy.negozio.command.CustomerDeleteCommand;
import com.vlc2.academy.negozio.controller.CustomerController;
import com.vlc2.academy.negozio.dto.customer.CustomerCreateDTO;
import com.vlc2.academy.negozio.dto.customer.CustomerDeleteDTO;
import com.vlc2.academy.negozio.dto.customer.CustomerReadDTO;
import com.vlc2.academy.negozio.service.CustomerService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<CustomerReadDTO> createUser(@RequestBody CustomerCreateDTO customerCreateDTO){
        CustomerCreateCommand customerCreateCommand = beanFactory.getBean(CustomerCreateCommand.class, customerService, customerCreateDTO);
        return ResponseEntity.ok(customerCreateCommand.execute());
    }

    @GetMapping("/customers/id/{customerId}")
    public ResponseEntity<CustomerReadDTO> getUserById(@PathVariable Integer customerId) {

        return ResponseEntity.ok(customerService.getUserById(customerId));

    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerReadDTO>> getUsers(){

        return ResponseEntity.ok(customerService.getUsers());
    }

    @GetMapping("/customers/name/{customerName}")
    public ResponseEntity<List<CustomerReadDTO>> getUsersByName(@PathVariable String customerName) {

        return ResponseEntity.ok(customerService.getUsersByName(customerName));
    }

    @GetMapping("/customers/alphabetically")
    public ResponseEntity<List<CustomerReadDTO>> getUsersAlphabetically(){

        return ResponseEntity.ok(customerService.getUsersAlphabetically());
    }

    @DeleteMapping("/customers")
    public ResponseEntity<CustomerReadDTO> deleteCustomer(CustomerDeleteDTO customerDeleteDTO){
        CustomerDeleteCommand customerDeleteCommand = beanFactory.getBean(CustomerDeleteCommand.class, customerService, customerDeleteDTO);
        return ResponseEntity.ok(customerDeleteCommand.execute());
    }


}
