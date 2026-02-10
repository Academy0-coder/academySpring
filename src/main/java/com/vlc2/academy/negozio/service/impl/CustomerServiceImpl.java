package com.vlc2.academy.negozio.service.impl;

import com.vlc2.academy.negozio.dto.customer.CustomerCreateDTO;
import com.vlc2.academy.negozio.dto.customer.CustomerReadDTO;
import com.vlc2.academy.negozio.entity.Customer;
import com.vlc2.academy.negozio.mapper.CustomerMapper;
import com.vlc2.academy.negozio.repository.CustomerRepository;
import com.vlc2.academy.negozio.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<CustomerReadDTO> getUsers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerReadDTO> customersDTO = customers.stream()
                .map(customer -> customerMapper.toDTO(customer))
                .toList();
        return customersDTO;
    }

    @Override
    public void createUser(CustomerCreateDTO customerCreateDTO) {

        Customer customer = new Customer(customerCreateDTO.getName(), customerCreateDTO.getSurname());

        Customer saved = customerRepository.save(customer);

    }
}
