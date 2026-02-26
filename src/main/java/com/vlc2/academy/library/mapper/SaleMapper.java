package com.vlc2.academy.library.mapper;

import com.vlc2.academy.library.dto.request.SaleRequest;
import com.vlc2.academy.library.dto.response.SaleResponse;
import com.vlc2.academy.library.entity.Book;
import com.vlc2.academy.library.entity.Sale;
import com.vlc2.academy.library.service.BookService;
import com.vlc2.academy.library.utility.DateUtility;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SaleMapper {





    // --------------------------------
    // ENTITY MAPPERS
    // --------------------------------
    // From Entity To Dto
    SaleResponse toDto(Sale sale);

    // From a List of Entities to a List of Dtos
    List<SaleResponse> listToDto(List<Sale> sales);

    // From a Request Dto to an Entity
    @Mapping(target = "book", source = "book", qualifiedByName = "stringToBook")
    @Mapping(target = "month", source = "date", qualifiedByName = "getMonth")
    @Mapping(target = "week", source = "date", qualifiedByName = "getWeek")
    Sale toEntity(SaleRequest saleRequest, @Context BookService bookService);





    // --------------------------------
    // DEFAULT MAPPERS
    // --------------------------------
    // From a String to a Book (which has as name the string passed in input)
    @Named("stringToBook")
    default Book stringToBook(String book, @Context BookService bookService){

        return bookService.findByName(book);
    }


    // From Date to Integer (representing the month)
    // For additional info look at the class DateUtility
    @Named("getMonth")
    default Integer getMonth(LocalDate date){
        return DateUtility.extractMonth(date);
    }



    // From Date to Integer (representing the week)
    // For additional info look at the class DateUtility
    @Named("getWeek")
    default Integer getWeek(LocalDate date){
        return DateUtility.extractWeek(date);
    }


    // From Book to String (its name)
    default String bookToString(Book book){
        return book.getName();
    }

}
