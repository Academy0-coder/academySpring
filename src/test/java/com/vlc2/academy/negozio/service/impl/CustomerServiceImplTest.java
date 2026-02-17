package com.vlc2.academy.negozio.service.impl;

import com.vlc2.academy.negozio.dto.customer.CustomerCreateDTO;
import com.vlc2.academy.negozio.dto.customer.CustomerDeleteDTO;
import com.vlc2.academy.negozio.dto.customer.CustomerReadDTO;
import com.vlc2.academy.negozio.entity.Customer;
import com.vlc2.academy.negozio.mapper.CustomerMapper;
import com.vlc2.academy.negozio.repository.CustomerRepository;
import com.vlc2.academy.negozio.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    CustomerRepository repo;

    @Mock
    CustomerMapper mapper;

    @InjectMocks
    CustomerServiceImpl service;

    CustomerReadDTO dto1 = new CustomerReadDTO(1,"a","b");
    CustomerReadDTO dto2 = new CustomerReadDTO(2,"c","d");
    Customer cust1 = new Customer("a","b");
    Customer cust2 = new Customer("c","d");
    CustomerDeleteDTO del = new CustomerDeleteDTO(1);


    @Test
    void createUser() {
        when(mapper.toDTO(any())).thenReturn(dto1);
        CustomerCreateDTO createDTO = new CustomerCreateDTO("a","b");
        Assertions.assertTrue(dto1.equals(service.createUser(createDTO)));
    }

    @Test
    void getUserById() {
        when(mapper.toDTO(any())).thenReturn(dto1);
        when(repo.findById(1)).thenReturn(Optional.of(cust1));
        Assertions.assertEquals(dto1,service.getUserById(1));
    }

    @Test
    void getUsers() {
        when(mapper.ListToDTO(any())).thenReturn(List.of(dto1,dto2));
        when(repo.findAll()).thenReturn(List.of(cust1,cust2));
        Assertions.assertEquals(List.of(dto1,dto2),service.getUsers());
    }

    @Test
    void getUsersAlphabetically() {
        when(mapper.ListToDTO(any())).thenReturn(List.of(dto1,dto2));
        when(repo.findAllOrderedAlphabetically()).thenReturn(List.of(cust1,cust2));
        Assertions.assertEquals(List.of(dto1,dto2),service.getUsersAlphabetically());
    }

    @Test
    void getUsersByName() {
        when(mapper.ListToDTO(any())).thenReturn(List.of(dto1));
        when(repo.findByName(any())).thenReturn(List.of(cust1));
        Assertions.assertEquals(List.of(dto1),service.getUsersByName("a"));
    }

    @Test
    void deleteUser() {
        CustomerDeleteDTO delete = new CustomerDeleteDTO(1);
        when(repo.findById(1)).thenReturn(Optional.of(cust1));
        when(mapper.toDTO(any())).thenReturn(dto1);
        Assertions.assertTrue(dto1.equals(service.deleteUser(delete)));
    }
}