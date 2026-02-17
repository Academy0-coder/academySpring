package com.vlc2.academy.negozio.service.impl;

import com.vlc2.academy.negozio.dto.customer.CustomerCreateDTO;
import com.vlc2.academy.negozio.dto.customer.CustomerDeleteDTO;
import com.vlc2.academy.negozio.dto.customer.CustomerReadDTO;
import com.vlc2.academy.negozio.entity.Customer;
import com.vlc2.academy.negozio.exceptions.CustomerNotFound;
import com.vlc2.academy.negozio.mapper.CustomerMapper;
import com.vlc2.academy.negozio.repository.CustomerRepository;
import com.vlc2.academy.negozio.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;
    CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl (CustomerRepository customerRepository, CustomerMapper customerMapper){
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerReadDTO createUser(CustomerCreateDTO customerCreateDTO) {
        Customer customer = new Customer(customerCreateDTO.getName(), customerCreateDTO.getSurname());
        customerRepository.save(customer);
        return customerMapper.toDTO(customer);
    }

    @Override
    public CustomerReadDTO getUserById(Integer id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFound(String.format("There isn't any customer with id = %d",id)));
        return customerMapper.toDTO(customer);
    }

    @Override
    public List<CustomerReadDTO> getUsers() {
        List<Customer> customers = customerRepository.findAll();
        return customerMapper.ListToDTO(customers);
    }

    @Override
    public List<CustomerReadDTO> getUsersAlphabetically() {
        List<Customer> customers = customerRepository.findAllOrderedAlphabetically();
        return customerMapper.ListToDTO(customers);
    }


    @Override
    public List<CustomerReadDTO> getUsersByName(String name) {
        List<Customer> customers = customerRepository.findByName(name);
        return customerMapper.ListToDTO(customers);
    }

    @Override
    public CustomerReadDTO deleteUser(CustomerDeleteDTO customerDeleteDTO) {
        Integer id = customerDeleteDTO.getId();
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFound(String.format("There isn't any customer with id = %d",id)));
        customerRepository.delete(customer);
        return customerMapper.toDTO(customer);
    }



}
