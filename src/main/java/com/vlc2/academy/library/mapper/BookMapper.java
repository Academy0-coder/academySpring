package com.vlc2.academy.library.mapper;

import com.vlc2.academy.library.dto.request.BookRequest;
import com.vlc2.academy.library.dto.response.BookResponse;
import com.vlc2.academy.library.entity.Book;
import com.vlc2.academy.library.entity.Editor;
import com.vlc2.academy.library.service.EditorService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Year;
import java.util.List;


@Mapper(componentModel = "spring", uses = {EditorService.class})
public interface BookMapper {

    BookResponse toDto(Book book);

    List<BookResponse> listToDto(List<Book> books);

    @Mapping(target = "quantitySold", constant = "0")
    @Mapping(target = "editor", source = "editor", qualifiedByName = "stringToEditor")
    Book toEntity(BookRequest request, @Context EditorService editorService, @Context EditorMapper editorMapper);

    default Year mappedYear(Integer year){
        return Year.of(year);
    }

    default BigDecimal mappedPrice(Double price){
        return BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_UP);
    }

    @Named("stringToEditor")
    default Editor stringToEditor(String editor, @Context EditorService editorService, @Context EditorMapper editorMapper){

        return editorService.getEntityByName(editor);
    }

    default String editorToString(Editor editor){
        return editor.getName();
    }


}
