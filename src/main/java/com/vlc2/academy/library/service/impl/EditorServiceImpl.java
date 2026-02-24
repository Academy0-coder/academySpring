package com.vlc2.academy.library.service.impl;

import com.vlc2.academy.library.dto.request.EditorRequest;
import com.vlc2.academy.library.dto.response.EditorResponse;
import com.vlc2.academy.library.entity.Editor;
import com.vlc2.academy.library.mapper.BookMapper;
import com.vlc2.academy.library.mapper.EditorMapper;
import com.vlc2.academy.library.repository.EditorRepository;
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
public class EditorServiceImpl implements EditorService {

    private final EditorRepository repository;
    private final EditorMapper mapper;
    private final BookMapper bookMapper;


    @Override
    public EditorResponse save(EditorRequest request) {
        Editor editor = mapper.toEntity(request);
        repository.save(editor);
        return mapper.toDto(editor, bookMapper);
    }

    @Override
    public EditorResponse findById(Integer id) {
        Optional<Editor> editor = repository.findById(id);
        return mapper.toDto(editor.orElseThrow(
                () -> new EntityNotFoundException(String.format("There's no editor with id: '%s'", id)
                )), bookMapper);
    }

    @Override
    public EditorResponse findByName(String name) {
        Optional<Editor> editor = repository.findByName(name);
        return mapper.toDto(editor.orElseThrow(
                () -> new EntityNotFoundException(String.format("There's no editor with name: '%s'", name)
                )), bookMapper);
    }

    @Override
    public Editor getEntityByName(String name) {
        Optional<Editor> editor = repository.findByName(name);
        return editor.orElseThrow(
                () -> new EntityNotFoundException(String.format("There's no editor with name: '%s'", name)));
    }

    @Override
    public EditorResponse findByEmail(String email) {
        Optional<Editor> editor = repository.findByEmail(email);
        return mapper.toDto(editor.orElseThrow(
                () -> new EntityNotFoundException(String.format("There's no editor with email: '%s'", email)
        )), bookMapper);

    }


    @Override
    public List<EditorResponse> findAll() {
        return mapper.listToDto(repository.findAll(), bookMapper);
    }

    @Override
    public Boolean existsByName(String name){
        return repository.findByName(name).isPresent();
    }

    @Override
    public Boolean existsByEmail(String email){
        return repository.findByEmail(email).isPresent();
    }





}
