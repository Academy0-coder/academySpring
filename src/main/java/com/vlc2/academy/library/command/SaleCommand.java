package com.vlc2.academy.library.command;

import com.vlc2.academy.library.dto.request.SaleRequest;
import com.vlc2.academy.library.dto.response.SaleResponse;
import com.vlc2.academy.library.exception.custom.InvalidDateException;
import com.vlc2.academy.library.exception.custom.InvalidEditorException;
import com.vlc2.academy.library.exception.custom.NullInsertException;
import com.vlc2.academy.library.service.SaleService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Getter
@RequiredArgsConstructor
public class SaleCommand {

    private final SaleService service;
    private final SaleRequest request;


    public SaleResponse execute() {
        validate();
        return service.save(request);
    }

    public void validate(){

        if(request.getBook() == null || request.getBook().isEmpty()){
            throw new NullInsertException("You must provide a book");
        }
        if(request.getDate() == null ||
                request.getDate().isAfter(LocalDate.now().plusYears(1)) ||
                request.getDate().isBefore(LocalDate.now().minusYears(5))){
            throw new InvalidDateException("You must provide a valid date," +
                    " you can't insert a date previous to 5 years ago or subsequent to a year from now");
        }
        if(!service.existsByBook(request.getBook())){
            throw new InvalidEditorException(String.format("There's no book named %s",request.getBook()));
        }
    }
}
