package com.vlc2.academy.negozio.controller;

import com.vlc2.academy.negozio.dto.customer.CustomerReadDTO;
import com.vlc2.academy.negozio.dto.invoice.InvoiceCreateDTO;
import com.vlc2.academy.negozio.dto.invoice.InvoiceReadDTO;
import com.vlc2.academy.negozio.dto.invoice.TimeSpan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Instant;
import java.util.List;

public interface InvoiceController {

    ResponseEntity<Void> executeTransaction(InvoiceCreateDTO invoiceCreateDto);

    ResponseEntity<InvoiceReadDTO> getInvoiceById(Integer invoiceId);
    ResponseEntity<List<InvoiceReadDTO>> getInvoices();
    ResponseEntity<List<InvoiceReadDTO>> getInvoicesInATimeSpan(TimeSpan timeSpan);
    ResponseEntity<List<InvoiceReadDTO>> getInvoicesByUser(Integer customerId);
    ResponseEntity<List<InvoiceReadDTO>> getInvoicesByProduct(Integer productId);

}
