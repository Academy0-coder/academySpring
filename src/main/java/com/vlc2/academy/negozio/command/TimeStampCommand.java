package com.vlc2.academy.negozio.command;

import com.vlc2.academy.negozio.dto.invoice.InvoiceReadDTO;
import com.vlc2.academy.negozio.dto.invoice.TimeSpan;
import com.vlc2.academy.negozio.service.InvoiceService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Getter
@Setter
@RequiredArgsConstructor
public class TimeStampCommand {

    private final InvoiceService invoiceService;
    private final TimeSpan timeSpan;

    public List<InvoiceReadDTO> execute(){
        if (canExecute()){
            return doExecute();
        }
        return List.of();
    }

    private boolean canExecute(){
        return !(timeSpan.getStart() == null || timeSpan.getEnd() == null);
    }

    public List<InvoiceReadDTO> doExecute(){
        return invoiceService.getInvoicesInATimeSpan(timeSpan);
    }
}
