package com.vlc2.academy.negozio.controller;

import com.vlc2.academy.negozio.dto.customer.CustomerReadDTO;
import com.vlc2.academy.negozio.dto.invoice.InvoiceCreateDTO;
import com.vlc2.academy.negozio.dto.invoice.InvoiceReadDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InvoiceController {

    ResponseEntity<Void> executeTransaction(InvoiceCreateDTO invoiceCreateDto);

    ResponseEntity<InvoiceReadDTO> getInvoiceById(Integer invoiceId);
    ResponseEntity<List<InvoiceReadDTO>> getInvoices();

}
