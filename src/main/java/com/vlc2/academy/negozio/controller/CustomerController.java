package com.vlc2.academy.negozio.controller;

import com.vlc2.academy.negozio.dto.customer.CustomerCreateDTO;
import com.vlc2.academy.negozio.dto.customer.CustomerReadDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerController {

    ResponseEntity<List<CustomerReadDTO>> getUsers();
    ResponseEntity<Void> createUser(CustomerCreateDTO customerCreateDTO);

}
