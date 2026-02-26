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

    SaleResponse toDto(Sale sale);

    List<SaleResponse> listToDto(List<Sale> sales);

    @Mapping(target = "book", source = "book", qualifiedByName = "stringToBook")
    @Mapping(target = "month", source = "date", qualifiedByName = "getMonth")
    @Mapping(target = "week", source = "date", qualifiedByName = "getWeek")
    Sale toEntity(SaleRequest saleRequest, @Context BookService bookService);

    @Named("stringToBook")
    default Book stringToBook(String book, @Context BookService bookService){

        return bookService.getEntityByName(book);
    }

    @Named("getMonth")
    default Integer getMonth(LocalDate date){
        return DateUtility.extractMonth(date);
    }

    @Named("getWeek")
    default Integer getWeek(LocalDate date){
        return DateUtility.extractWeek(date);
    }

    default String bookToString(Book book){
        return book.getName();
    }

}
