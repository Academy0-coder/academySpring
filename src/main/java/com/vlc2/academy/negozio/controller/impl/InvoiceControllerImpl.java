package com.vlc2.academy.negozio.controller.impl;

import com.vlc2.academy.negozio.command.InvoiceCommand;
import com.vlc2.academy.negozio.controller.InvoiceController;
import com.vlc2.academy.negozio.dto.invoice.InvoiceCreateDTO;
import com.vlc2.academy.negozio.dto.invoice.InvoiceReadDTO;
import com.vlc2.academy.negozio.dto.product.ProductReadDTO;
import com.vlc2.academy.negozio.service.InvoiceService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class InvoiceControllerImpl implements InvoiceController {

    private InvoiceService invoiceService;
    private BeanFactory beanFactory;

    public InvoiceControllerImpl(InvoiceService invoiceService, BeanFactory beanFactory){
        this.invoiceService = invoiceService;
        this.beanFactory = beanFactory;
    }

    @PostMapping("/invoices")
    public ResponseEntity<Void> executeTransaction(@RequestBody InvoiceCreateDTO invoiceCreateDto){
        InvoiceCommand invoiceCommand = beanFactory.getBean(InvoiceCommand.class, invoiceService, invoiceCreateDto);
        invoiceCommand.execute();
        return ResponseEntity.ok(null);
    }

    @GetMapping("/invoices/{invoiceId}")
    public ResponseEntity<InvoiceReadDTO> getInvoiceById(@PathVariable Integer invoiceId) {

        return ResponseEntity.ok(invoiceService.getInvoiceById(invoiceId));

    }

    @GetMapping("/invoices")
    public ResponseEntity<List<InvoiceReadDTO>> getInvoices(){
        return ResponseEntity.ok(invoiceService.getInvoices());
    }

}
