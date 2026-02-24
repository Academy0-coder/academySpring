package com.vlc2.academy.library.service;

import com.vlc2.academy.library.dto.request.BookRequest;
import com.vlc2.academy.library.dto.response.BookResponse;

import java.util.List;

public interface BookService {

    BookResponse save(BookRequest request);
    BookResponse findById(Integer id);
    BookResponse findByName(String name);
    List<BookResponse> findAll();
    Boolean existsByName(String name);
}
