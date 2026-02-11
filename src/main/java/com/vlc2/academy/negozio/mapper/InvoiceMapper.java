package com.vlc2.academy.negozio.mapper;

import com.vlc2.academy.negozio.dto.invoice.InvoiceReadDTO;
import com.vlc2.academy.negozio.dto.product.ProductReadDTO;
import com.vlc2.academy.negozio.entity.Invoice;
import com.vlc2.academy.negozio.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvoiceMapper {

    public InvoiceReadDTO toDTO (Invoice invoice){
        return new InvoiceReadDTO(invoice.getId(),
                invoice.getQuantity(),
                invoice.getCustomer().getName(),
                invoice.getCustomer().getSurname(),
                invoice.getProduct().getName(),
                invoice.getProduct().getPrice(),
                invoice.getTimestamp());
    }

    public List<InvoiceReadDTO> toDTO(List<Invoice> invoices){

        return invoices.stream()
                .map(invoice -> toDTO(invoice))
                .toList();

    }

}
