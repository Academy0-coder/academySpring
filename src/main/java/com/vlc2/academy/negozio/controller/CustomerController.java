package com.vlc2.academy.negozio.controller;

import com.vlc2.academy.negozio.dto.customer.CustomerCreateDTO;
import com.vlc2.academy.negozio.dto.customer.CustomerReadDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CustomerController {

    ResponseEntity<Void> createUser(CustomerCreateDTO customerCreateDTO);

    ResponseEntity<CustomerReadDTO> getUserById(Integer customerId);
    ResponseEntity<List<CustomerReadDTO>> getUsers();

}
