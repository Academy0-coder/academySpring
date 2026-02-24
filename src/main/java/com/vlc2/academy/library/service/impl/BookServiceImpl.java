package com.vlc2.academy.library.service.impl;

import com.vlc2.academy.library.dto.request.BookRequest;
import com.vlc2.academy.library.dto.response.BookResponse;
import com.vlc2.academy.library.entity.Book;
import com.vlc2.academy.library.entity.Editor;
import com.vlc2.academy.library.mapper.BookMapper;
import com.vlc2.academy.library.mapper.EditorMapper;
import com.vlc2.academy.library.repository.BookRepository;
import com.vlc2.academy.library.repository.EditorRepository;
import com.vlc2.academy.library.service.BookService;
import com.vlc2.academy.library.service.EditorService;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Getter
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final BookMapper mapper;

    private final EditorRepository editorRepository;
    private final EditorMapper editorMapper;
    private final EditorService editorService;



    @Override
    public BookResponse save(BookRequest request) {
        Book book = mapper.toEntity(request, editorService, editorMapper);
        Editor editor = editorRepository.findByName(request.getEditor()).get();
        editor.getBooks().add(book);
        repository.save(book);
        return mapper.toDto(book);
    }

    @Override
    public BookResponse findById(Integer id) {
        Optional<Book> book = repository.findById(id);
        return mapper.toDto(book.orElseThrow(
                () -> new EntityNotFoundException(String.format("There's no book with id: '%s'", id)
                )));
    }

    @Override
    public BookResponse findByName(String name) {
        Optional<Book> book = repository.findByName(name);
        return mapper.toDto(book.orElseThrow(
                () -> new EntityNotFoundException(String.format("There's no book with name: '%s'", name)
                )));
    }


    @Override
    public List<BookResponse> findAll() {
        return mapper.listToDto(repository.findAll());
    }

    @Override
    public Boolean existsByName(String name) {
        return repository.findByName(name).isPresent();
    }


}
