package com.vlc2.academy.library.controller;

import com.vlc2.academy.library.command.EditorCommand;
import com.vlc2.academy.library.dto.request.EditorRequest;
import com.vlc2.academy.library.dto.response.EditorResponse;
import com.vlc2.academy.library.service.EditorService;
import com.vlc2.academy.library.utility.StringUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editor")
@RequiredArgsConstructor
public class EditorController {

    private final EditorService service;
    private final BeanFactory beanFactory;

    @PostMapping()
    public ResponseEntity<EditorResponse> createEditor(@RequestBody EditorRequest editor) {

        editor.setName(StringUtility.toUpperCamelCase(editor.getName()));
        editor.setEmail(editor.getEmail().toLowerCase());
        EditorCommand command = beanFactory.getBean(EditorCommand.class, service, editor);
        return ResponseEntity.ok(command.execute());
    }

    @GetMapping()
    public ResponseEntity<List<EditorResponse>> getAllEditors() {

        return ResponseEntity.ok(service.getAllEditors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EditorResponse> getEditorById(@PathVariable Integer id) {

        return ResponseEntity.ok(service.getEditorById(id));
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<EditorResponse> findEditorByName(@PathVariable String name) {

        return ResponseEntity.ok(service.getEditorByName(name));
    }


    @GetMapping("/email/{email}")
    public ResponseEntity<EditorResponse> findEditorByEmail(@PathVariable String email) {

        return ResponseEntity.ok(service.getEditorByEmail(email));
    }

}
