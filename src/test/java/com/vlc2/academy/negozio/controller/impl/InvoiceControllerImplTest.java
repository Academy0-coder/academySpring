package com.vlc2.academy.negozio.controller.impl;

import com.vlc2.academy.negozio.command.InvoiceCommand;
import com.vlc2.academy.negozio.dto.invoice.InvoiceCreateDTO;
import com.vlc2.academy.negozio.dto.invoice.InvoiceReadDTO;
import com.vlc2.academy.negozio.dto.invoice.TimeSpan;
import com.vlc2.academy.negozio.service.InvoiceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class InvoiceControllerImplTest {

    @Mock
    InvoiceService service;

    @Mock
    BeanFactory factory;


    @InjectMocks
    InvoiceControllerImpl controller;

    InvoiceReadDTO read = new InvoiceReadDTO(1, 1, "a", "a", "a", Instant.now(), BigDecimal.valueOf(1), BigDecimal.valueOf(1.22));
    InvoiceReadDTO read2 = new InvoiceReadDTO(2, 2, "b", "b", "b", Instant.now(), BigDecimal.valueOf(2), BigDecimal.valueOf(2.44));
    InvoiceCommand command = new InvoiceCommand();


    @Test
    void executeTransaction() {
        InvoiceCreateDTO request = new InvoiceCreateDTO(1,1,1);
        command.setInvoiceService(service);
        command.setInvoiceCreateDTO(request);
        when(factory.getBean(InvoiceCommand.class,service,request)).thenReturn(command);
        Assertions.assertNotNull(controller.executeTransaction(request));
    }

    @Test
    void getInvoiceById() {
        Integer id = read.getId();
        when(service.getInvoiceById(id)).thenReturn(read);
        Assertions.assertEquals(ResponseEntity.ok(read),controller.getInvoiceById(id));
    }

    @Test
    void getInvoices() {
        when(service.getInvoices()).thenReturn(List.of(read,read2));
        Assertions.assertEquals(ResponseEntity.ok(List.of(read,read2)),controller.getInvoices());
    }

    @Test
    void getInvoicesInATimeSpan() {
        TimeSpan timeSpan = new TimeSpan(Instant.now().minusSeconds(60),Instant.now().plusSeconds(60));


    }

    @Test
    void getInvoicesByCustomerId() {
        Integer id = 1;
        when(service.getInvoicesByCustomerId(id)).thenReturn(List.of(read,read2));
        Assertions.assertEquals(ResponseEntity.ok(List.of(read,read2)),controller.getInvoicesByUser(id));
    }

    @Test
    void getInvoicesByProductId() {
        Integer id = 1;
        when(service.getInvoicesByProductId(id)).thenReturn(List.of(read,read2));
        Assertions.assertEquals(ResponseEntity.ok(List.of(read,read2)),controller.getInvoicesByProduct(id));
    }
}