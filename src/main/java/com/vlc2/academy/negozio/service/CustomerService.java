package com.vlc2.academy.negozio.service;

import com.vlc2.academy.negozio.dto.customer.CustomerCreateDTO;
import com.vlc2.academy.negozio.dto.customer.CustomerReadDTO;

import java.util.List;

public interface CustomerService {

    // CREATE
    // Save a new user
    void createUser(CustomerCreateDTO customerCreateDTO);

    // READ
    // Get all users
    List<CustomerReadDTO> getUsers();


}
