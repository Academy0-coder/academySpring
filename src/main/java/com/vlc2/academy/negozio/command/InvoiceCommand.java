package com.vlc2.academy.negozio.command;

import com.vlc2.academy.negozio.dto.invoice.InvoiceCreateDTO;
import com.vlc2.academy.negozio.dto.invoice.InvoiceReadDTO;
import com.vlc2.academy.negozio.service.InvoiceService;
import lombok.*;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceCommand {

    private InvoiceService invoiceService;
    private InvoiceCreateDTO invoiceCreateDTO;

    public InvoiceReadDTO execute(){
        if (canExecute()){
            return doExecute();
        }
        if(invoiceCreateDTO.getQuantity() == null || invoiceCreateDTO.getCustomerId() == null || invoiceCreateDTO.getProductId() == null){
            throw new NullPointerException("Fields can't be null");
        }
        throw new IllegalArgumentException("Fields must be positive integers");
    }

    private boolean canExecute(){
        return !((invoiceCreateDTO.getQuantity() == null || invoiceCreateDTO.getQuantity() <= 0)
                ||(invoiceCreateDTO.getCustomerId() == null || invoiceCreateDTO.getCustomerId() <= 0)
                ||(invoiceCreateDTO.getProductId() == null || invoiceCreateDTO.getProductId() <= 0));
    }

    private InvoiceReadDTO doExecute(){
        return invoiceService.executeTransaction(invoiceCreateDTO);
    }
}
