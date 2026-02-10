package com.vlc2.academy.negozio.service.impl;

import com.vlc2.academy.negozio.dto.customer.CustomerCreateDTO;
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
    public void createUser(CustomerCreateDTO customerCreateDTO) {

        Customer customer = new Customer(customerCreateDTO.getName(), customerCreateDTO.getSurname());

        Customer saved = customerRepository.save(customer);

    }

    @Override
    public CustomerReadDTO getUserById(Integer id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFound(String.format("There isn't any customer with id = %d",id)));
        CustomerReadDTO customerReadDTO = customerMapper.toDTO(customer);
        return customerReadDTO;
    }

    @Override
    public List<CustomerReadDTO> getUsers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerReadDTO> customersDTO = customers.stream()
                .map(customer -> customerMapper.toDTO(customer))
                .toList();
        return customersDTO;
    }




}
