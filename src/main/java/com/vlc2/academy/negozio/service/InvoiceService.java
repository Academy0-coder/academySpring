package com.vlc2.academy.negozio.service;

import com.vlc2.academy.negozio.dto.customer.CustomerReadDTO;
import com.vlc2.academy.negozio.dto.invoice.InvoiceCreateDTO;
import com.vlc2.academy.negozio.dto.invoice.InvoiceReadDTO;
import com.vlc2.academy.negozio.dto.invoice.TimeSpan;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

public interface InvoiceService {

    // CREATE
    // Do a transaction and create a new invoice
    InvoiceReadDTO executeTransaction (InvoiceCreateDTO invoiceCreateDTO);

    // READ
    // Get a customer by id
    InvoiceReadDTO getInvoiceById(Integer id);

    // Get all invoices
    List<InvoiceReadDTO> getInvoices();

    // Get all invoices in a time span
    List<InvoiceReadDTO> getInvoicesInATimeSpan(TimeSpan timeSpan);

    // Get all invoices for a specific customer
    List<InvoiceReadDTO> getInvoicesByCustomerId(Integer id);

    // Get all invoices for a specific product
    List<InvoiceReadDTO> getInvoicesByProductId(Integer id);
}
