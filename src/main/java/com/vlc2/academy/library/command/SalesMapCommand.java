package com.vlc2.academy.library.command;

import com.vlc2.academy.library.dto.response.SalesMapResponse;
import com.vlc2.academy.library.exception.custom.NullInsertException;
import com.vlc2.academy.library.service.SaleService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Map;


@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Getter
@RequiredArgsConstructor
public class SalesMapCommand {

    private final SaleService service;
    private final LocalDate day;


    public SalesMapResponse executeWeek() {
        validate();
        return service.rankByWeek(day);
    }

    public SalesMapResponse executeMonth() {
        validate();
        return service.rankByMonth(day);
    }

    public void validate(){

        if(day == null){
            throw new NullInsertException("Day can't be null");
        }
    }
}
