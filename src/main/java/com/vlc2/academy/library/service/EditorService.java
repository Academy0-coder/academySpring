package com.vlc2.academy.library.service;

import com.vlc2.academy.library.dto.request.EditorRequest;
import com.vlc2.academy.library.dto.response.EditorResponse;
import com.vlc2.academy.library.entity.Editor;

import java.util.List;

public interface EditorService {

    void save(Editor editor);
    Editor findById(Integer id);
    Editor findByName(String name);
    Editor findByEmail(String email);
    List<Editor> findAll();
    Boolean existsByName(String name);
    Boolean existsByEmail(String email);
    void setValuesAfterOrder(Integer days, Integer editor);

    EditorResponse insert(EditorRequest request);
    EditorResponse getEditorById(Integer id);
    EditorResponse getEditorByName(String name);
    EditorResponse getEditorByEmail(String name);
    List<EditorResponse> getAllEditors();

}
