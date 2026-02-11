package com.vlc2.academy.negozio.controller.impl;

import com.vlc2.academy.negozio.command.InvoiceCommand;
import com.vlc2.academy.negozio.command.TimeStampCommand;
import com.vlc2.academy.negozio.controller.InvoiceController;
import com.vlc2.academy.negozio.dto.invoice.InvoiceCreateDTO;
import com.vlc2.academy.negozio.dto.invoice.InvoiceReadDTO;
import com.vlc2.academy.negozio.dto.invoice.TimeSpan;
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
    public ResponseEntity<InvoiceReadDTO> executeTransaction(@RequestBody InvoiceCreateDTO invoiceCreateDto){
        InvoiceCommand invoiceCommand = beanFactory.getBean(InvoiceCommand.class, invoiceService, invoiceCreateDto);
        return ResponseEntity.ok(invoiceCommand.execute());
    }

    @GetMapping("/invoices/{invoiceId}")
    public ResponseEntity<InvoiceReadDTO> getInvoiceById(@PathVariable Integer invoiceId) {

        return ResponseEntity.ok(invoiceService.getInvoiceById(invoiceId));

    }

    @GetMapping("/invoices")
    public ResponseEntity<List<InvoiceReadDTO>> getInvoices(){
        return ResponseEntity.ok(invoiceService.getInvoices());
    }

    @PostMapping("invoices/time")
    public ResponseEntity<List<InvoiceReadDTO>> getInvoicesInATimeSpan(@RequestBody TimeSpan timeSpan){
        TimeStampCommand timeStampCommand = beanFactory.getBean(TimeStampCommand.class, invoiceService, timeSpan);
        return ResponseEntity.ok(timeStampCommand.execute());
    }

    @GetMapping("/invoices/customer/{customerId}")
    public ResponseEntity<List<InvoiceReadDTO>> getInvoicesByUser(@PathVariable Integer customerId) {
        return ResponseEntity.ok(invoiceService.getInvoicesByCustomerId(customerId));
    }

    @GetMapping("/invoices/product/{productId}")
    public ResponseEntity<List<InvoiceReadDTO>> getInvoicesByProduct(@PathVariable Integer productId) {
        return ResponseEntity.ok(invoiceService.getInvoicesByProductId(productId));
    }

}
