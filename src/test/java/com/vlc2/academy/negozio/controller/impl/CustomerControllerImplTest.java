package com.vlc2.academy.negozio.controller.impl;

import com.vlc2.academy.negozio.dto.customer.CustomerDeleteDTO;
import com.vlc2.academy.negozio.dto.customer.CustomerReadDTO;
import com.vlc2.academy.negozio.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CustomerControllerImplTest {

    @Mock
    CustomerService service;

    @Mock
    BeanFactory factory;

    @InjectMocks
    CustomerControllerImpl controller;

    CustomerReadDTO read = new CustomerReadDTO(1,"a","b");
    CustomerReadDTO read2 = new CustomerReadDTO(2,"c","d");
    ResponseEntity<CustomerReadDTO> response = ResponseEntity.ok(read);



//    @Test
//    void createUser() {
//
//        CustomerCreateDTO create = new CustomerCreateDTO("a","b");
//        CustomerCommand command = factory.getBean(CustomerCommand.class,service,create);
//        when().thenReturn(read);
//        Assertions.assertEquals(response.getClass(),controller.createUser(create).getClass());
//    }

    @Test
    void getUserById() {
        Integer id = read.getId();
        when(service.getUserById(id)).thenReturn(read);
        Assertions.assertEquals(ResponseEntity.ok(read),controller.getUserById(id));
    }

    @Test
    void getUsers() {
        when(service.getUsers()).thenReturn(List.of(read,read2));
        Assertions.assertEquals(ResponseEntity.ok(List.of(read,read2)),controller.getUsers());
    }

    @Test
    void getUsersByName() {
        String name = "a";
        when(service.getUsersByName(name)).thenReturn(List.of(read));
        Assertions.assertEquals(ResponseEntity.ok(List.of(read)),controller.getUsersByName("a"));
    }

    @Test
    void getUsersAlphabetically() {
        when(service.getUsersAlphabetically()).thenReturn(List.of(read,read2));
        Assertions.assertEquals(ResponseEntity.ok(List.of(read,read2)),controller.getUsersAlphabetically());
    }

    @Test
    void deleteCustomer() {
        CustomerDeleteDTO delete = new CustomerDeleteDTO(1);
        when(service.deleteUser(delete)).thenReturn(read);
        Assertions.assertEquals(ResponseEntity.ok(read),controller.deleteCustomer(delete));
    }
}