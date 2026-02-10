package com.vlc2.academy.negozio.mapper;

import com.vlc2.academy.negozio.dto.invoice.InvoiceReadDTO;
import com.vlc2.academy.negozio.entity.Invoice;
import org.springframework.stereotype.Component;

@Component
public class InvoiceMapper {

    public InvoiceReadDTO toDTO (Invoice invoice){
        return new InvoiceReadDTO(invoice.getId(),
                invoice.getQuantity(),
                invoice.getCustomer().getName(),
                invoice.getCustomer().getSurname(),
                invoice.getProduct().getName(),
                invoice.getProduct().getPrice());
    }

}
