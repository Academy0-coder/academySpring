package com.vlc2.academy.negozio.command;

import com.vlc2.academy.negozio.dto.invoice.InvoiceCreateDTO;
import com.vlc2.academy.negozio.dto.invoice.InvoiceReadDTO;
import com.vlc2.academy.negozio.service.InvoiceService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Getter
@Setter
@RequiredArgsConstructor
public class InvoiceCommand {

    private final InvoiceService invoiceService;
    private final InvoiceCreateDTO invoiceCreateDTO;

    public InvoiceReadDTO execute(){
        if (canExecute()){
            return doExecute();
        }
        return null;
    }

    private boolean canExecute(){
        return !(invoiceCreateDTO.getQuantity() == null || invoiceCreateDTO.getQuantity() <= 0);
    }

    private InvoiceReadDTO doExecute(){
        return invoiceService.executeTransaction(invoiceCreateDTO);
    }
}
