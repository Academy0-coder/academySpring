package com.vlc2.academy.library.service;

import com.vlc2.academy.library.dto.request.EditorRequest;
import com.vlc2.academy.library.dto.response.EditorResponse;
import com.vlc2.academy.library.entity.Editor;

import java.util.List;

public interface EditorService {

    EditorResponse save(EditorRequest request);
    EditorResponse findById(Integer id);
    EditorResponse findByName(String name);
    Editor getEntityByName(String name);
    EditorResponse findByEmail(String email);
    List<EditorResponse> findAll();
    Boolean existsByName(String name);
    Boolean existsByEmail(String email);

}
