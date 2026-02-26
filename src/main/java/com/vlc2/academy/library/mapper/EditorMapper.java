package com.vlc2.academy.library.mapper;

import com.vlc2.academy.library.dto.request.EditorRequest;
import com.vlc2.academy.library.dto.response.BookResponse;
import com.vlc2.academy.library.dto.response.EditorResponse;
import com.vlc2.academy.library.entity.Book;
import com.vlc2.academy.library.entity.Editor;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface EditorMapper {




    // --------------------------------
    // ENTITY MAPPERS
    // --------------------------------
    // From Entity To Dto
    EditorResponse toDto(Editor editor, @Context BookMapper bookMapper);

    // From a List of Entities to a List of Dtos
    List<EditorResponse> listToDto(List<Editor> editors, @Context BookMapper bookMapper);

    // From a Request Dto To An Entity (For CREATE Methods)
    Editor toEntity(EditorRequest request);






    // --------------------------------
    // DEFAULT MAPPERS
    // --------------------------------
    // From a List of Editors to a List of Strings (Their names)
    default List<BookResponse> editorToString(List<Book> books, @Context BookMapper bookMapper) {
        return books.stream()
                .map(book -> bookMapper.toDto(book))
                .collect(Collectors.toList());
    }

}
