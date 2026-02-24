package com.vlc2.academy.negozio.command;

import com.vlc2.academy.negozio.dto.customer.CustomerCreateDTO;
import com.vlc2.academy.negozio.dto.customer.CustomerReadDTO;
import com.vlc2.academy.negozio.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CustomerCommandTest {

    @Mock
    CustomerService service;

    @InjectMocks
    CustomerCommand command;

    CustomerReadDTO readDto = new CustomerReadDTO(1, "a", "a");
    CustomerCreateDTO dto = new CustomerCreateDTO("a","a");


    @BeforeEach
    void setUp() {
        command.setCustomerCreateDTO(dto);
    }

    @Test
    void execute() {
        when(service.createUser(any())).thenReturn(readDto);
        dto.setName("Mario");
        dto.setSurname("Rossi");
        Assertions.assertEquals(command.execute(),readDto);
    }

    @Test
    void executeNull() {
        dto.setName(null);
        dto.setSurname("Rossi");
        Assertions.assertThrows(NullPointerException.class , () -> command.execute());
    }

    @Test
    void executeInvalid() {
        dto.setName("Mario");
        dto.setSurname("  ");
        Assertions.assertThrows(IllegalArgumentException.class , () -> command.execute());

    }



}