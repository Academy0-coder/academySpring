package com.vlc2.academy.negozio.service;

import com.vlc2.academy.negozio.dto.customer.CustomerCreateDTO;
import com.vlc2.academy.negozio.dto.customer.CustomerDeleteDTO;
import com.vlc2.academy.negozio.dto.customer.CustomerReadDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CustomerService {

    // CREATE
    // Save a new user
    CustomerReadDTO createUser(CustomerCreateDTO customerCreateDTO);

    // READ
    // Get a customer by id
    CustomerReadDTO getUserById(Integer id);

    // Get users by name
    List<CustomerReadDTO> getUsersByName(String name);

    // Get all users
    List<CustomerReadDTO> getUsers();

    // Get all users ordered alphabetically
    List<CustomerReadDTO> getUsersAlphabetically();

    // DELETE
    // Remove a customer from the database
    CustomerReadDTO deleteUser(CustomerDeleteDTO customerDeleteDTO);
}
