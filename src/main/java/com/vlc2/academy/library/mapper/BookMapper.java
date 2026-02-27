package com.vlc2.academy.library.mapper;

import com.vlc2.academy.library.dto.request.BookRequest;
import com.vlc2.academy.library.dto.response.BookResponse;
import com.vlc2.academy.library.dto.response.OrderResponse;
import com.vlc2.academy.library.dto.response.SaleResponse;
import com.vlc2.academy.library.entity.Book;
import com.vlc2.academy.library.entity.Editor;
import com.vlc2.academy.library.entity.Order;
import com.vlc2.academy.library.entity.Sale;
import com.vlc2.academy.library.service.EditorService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring", uses = {EditorService.class})
public interface BookMapper {




    // --------------------------------
    // ENTITY MAPPERS
    // --------------------------------

    // From Entity To Dto
    BookResponse toDto(Book book);

    // From a List of Entities to a List of Dtos
    List<BookResponse> listToDto(List<Book> books);

    // From a Request Dto To An Entity (For CREATE Methods)
    @Mapping(target = "quantitySold", constant = "0")
    @Mapping(target = "editor", source = "editor", qualifiedByName = "stringToEditor")
    Book toEntity(BookRequest request, @Context EditorService editorService);





    // --------------------------------
    // DEFAULT MAPPERS
    // --------------------------------

    // Mapper from Integer to Year
    default Year mappedYear(Integer year){
        return Year.of(year);
    }

    // Mapper from Double to BigDecimal (Used for prices)
    default BigDecimal mappedPrice(Double price){
        return BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_UP);
    }

    @Named("stringToEditor")
    default Editor stringToEditor(String editor, @Context EditorService editorService){

        return editorService.findByName(editor);
    }

    default String editorToString(Editor editor){
        return editor.getName();
    }

}
