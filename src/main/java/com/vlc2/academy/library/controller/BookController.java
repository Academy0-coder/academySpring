package com.vlc2.academy.library.controller;

import com.vlc2.academy.library.command.BookCommand;
import com.vlc2.academy.library.dto.request.BookRequest;
import com.vlc2.academy.library.dto.response.BookResponse;
import com.vlc2.academy.library.service.BookService;
import com.vlc2.academy.library.service.EditorService;
import com.vlc2.academy.library.utility.StringUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;
    private final EditorService editorService;
    private final BeanFactory beanFactory;

    @PostMapping()
    public ResponseEntity<BookResponse> createBook(@RequestBody BookRequest book) {

        book.setName(StringUtility.capitalizeFirst(book.getName()));
        book.setAuthor(StringUtility.capitalizeFirst(book.getAuthor()));
        book.setEditor(StringUtility.capitalizeFirst(book.getEditor()));
        BookCommand command = beanFactory.getBean(BookCommand.class, service, editorService, book);
        return ResponseEntity.ok(command.execute());
    }


    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable Integer id) {

        return ResponseEntity.ok(service.getBookById(id));
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<BookResponse> getBookByName(@PathVariable String name) {

        return ResponseEntity.ok(service.getBookByName(name));
    }


    @GetMapping()
    public ResponseEntity<List<BookResponse>> getAllBooks() {

        return ResponseEntity.ok(service.getAllBooks());
    }


}
