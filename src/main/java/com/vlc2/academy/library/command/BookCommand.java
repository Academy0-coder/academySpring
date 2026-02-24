package com.vlc2.academy.library.command;

import com.vlc2.academy.library.dto.request.BookRequest;
import com.vlc2.academy.library.dto.response.BookResponse;
import com.vlc2.academy.library.exception.custom.*;
import com.vlc2.academy.library.exception.custom.InvalidBookException;
import com.vlc2.academy.library.service.BookService;
import com.vlc2.academy.library.service.EditorService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.Year;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Getter
@Setter
@RequiredArgsConstructor
public class BookCommand {

    private final BookService service;
    private final EditorService editorService;
    private final BookRequest request;


    public BookResponse execute() {
        validate();
        return service.save(request);
    }

    public void validate(){
        if(request.getName() == null || request.getName().isBlank()){
            throw new NullInsertException("You must provide a name");
        }
        if(request.getAuthor() == null || request.getAuthor().isBlank()){
            throw new NullInsertException("You must provide an author");
        }
        if(request.getEditor() == null || request.getAuthor().isBlank()){
            throw new NullInsertException("You must provide an editor");
        }
        if(request.getYear() == null || request.getYear()> Year.now().getValue()){
            throw new InvalidYearException("Year invalid");
        }
        if(request.getPrice() == null || request.getPrice()<= 0){
            throw new InvalidPriceException("You must provide a valid price");
        }
        if(request.getQuantityInStock() == null || request.getQuantityInStock() <= 0 || request.getQuantityInStock() > 1000){
            throw new InvalidQuantityException("Starting quality must be positive integer which can't exceed 1000 because of limited space in stock");
        }
        if(request.getThreshold() == null || request.getThreshold() < 0){
            throw new InvalidQuantityException("Threshold must be a positive integer or zero");
        }
        if(request.getRestock() == null || request.getRestock() <= 0){
            throw new InvalidQuantityException("Restock must be a positive integer");
        }
        if(request.getThreshold() >= request.getQuantityInStock()){
            throw new InvalidQuantityException("Starting quantity must be higher than threshold");
        }
        if(request.getRestock()+request.getThreshold() > 1000){
            throw new InvalidQuantityException("Restock and threshold must be a quantity such that after a restock you don't exceed 1000 units");
        }
        if(service.existsByName(request.getName())){
            throw new InvalidBookException(String.format("There's already a book called %s",request.getName()));
        }
        if(!editorService.existsByName(request.getEditor())){
            throw new InvalidBookException(String.format("There's no editor name %s",request.getEditor()));
        }


    }

}
