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
    private final InvoiceCreateDTO dto;

    public void execute(){
        if (canExecute()){
            doExecute();
        }
    }

    private boolean canExecute(){
        return !(dto.getQuantity() == null || dto.getQuantity() <= 0);
    }

    private void doExecute(){
        invoiceService.executeTransaction(dto);
    }
}
