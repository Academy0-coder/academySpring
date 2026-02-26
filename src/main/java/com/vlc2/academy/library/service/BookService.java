package com.vlc2.academy.library.service;

import com.vlc2.academy.library.dto.request.BookRequest;
import com.vlc2.academy.library.dto.response.BookResponse;
import com.vlc2.academy.library.entity.Book;

import java.time.LocalDate;
import java.util.List;

public interface BookService {

    void save(Book book);
    Book findById(Integer id);
    Book findByName(String name);
    List<Book> findAll();
    Boolean existsByName(String name);
    Boolean CheckStock(Book book, LocalDate date);
    void setValuesAfterSale(Book book);
    void setValuesAfterOrder(Book book);

    BookResponse insert(BookRequest request);
    BookResponse getBookById(Integer id);
    BookResponse getBookByName(String name);
    List<BookResponse> getAllBooks();
}
