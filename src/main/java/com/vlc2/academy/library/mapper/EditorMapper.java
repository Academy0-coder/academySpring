package com.vlc2.academy.library.mapper;

import com.vlc2.academy.library.dto.request.EditorRequest;
import com.vlc2.academy.library.dto.response.BookResponse;
import com.vlc2.academy.library.dto.response.EditorResponse;
import com.vlc2.academy.library.entity.Book;
import com.vlc2.academy.library.entity.Editor;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface EditorMapper {

    EditorResponse toDto(Editor editor, @Context BookMapper bookMapper);

    List<EditorResponse> listToDto(List<Editor> editors, @Context BookMapper bookMapper);

    Editor toEntity(EditorRequest request);

    default List<BookResponse> editorToString(List<Book> books, @Context BookMapper bookMapper){
        return books.stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

}
