package com.vlc2.academy.negozio.command;

import com.vlc2.academy.negozio.dto.invoice.InvoiceCreateDTO;
import com.vlc2.academy.negozio.dto.invoice.InvoiceReadDTO;
import com.vlc2.academy.negozio.service.InvoiceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class InvoiceCommandTest {

    @Mock
    InvoiceService service;

    @InjectMocks
    InvoiceCommand command;

    InvoiceReadDTO readDto = new InvoiceReadDTO(1, 1, "a", "a", "a",  1.1, Instant.now());



    @Test
    void executeValid() {
        when(service.executeTransaction(any())).thenReturn(readDto);
        InvoiceCreateDTO dto = new InvoiceCreateDTO(1,1, 1);
        command.setInvoiceCreateDTO(dto);
        Assertions.assertEquals(command.execute(),readDto);
    }

    @Test
    void executeNull() {
        InvoiceCreateDTO dto = new InvoiceCreateDTO(null,3, 5);
        command.setInvoiceCreateDTO(dto);
        Assertions.assertThrows(NullPointerException.class , () -> command.execute());
    }

    @Test
    void executeInvalid() {
        InvoiceCreateDTO dto = new InvoiceCreateDTO(3,6, -2);
        command.setInvoiceCreateDTO(dto);
        Assertions.assertThrows(IllegalArgumentException.class , () -> command.execute());

    }

}