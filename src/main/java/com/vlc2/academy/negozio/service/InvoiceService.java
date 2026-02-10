package com.vlc2.academy.negozio.service;

import com.vlc2.academy.negozio.dto.invoice.InvoiceCreateDTO;
import com.vlc2.academy.negozio.dto.invoice.InvoiceReadDTO;

import java.util.List;

public interface InvoiceService {

    // CREATE
    // Do a transaction and create a new invoice
    void executeTransaction (InvoiceCreateDTO invoiceCreateDTO);

    // READ
    // Get all invoices
    List<InvoiceReadDTO> getInvoices();

}
