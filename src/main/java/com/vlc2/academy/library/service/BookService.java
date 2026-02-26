package com.vlc2.academy.library.service;

import com.vlc2.academy.library.dto.request.BookRequest;
import com.vlc2.academy.library.dto.response.BookResponse;
import com.vlc2.academy.library.dto.response.SalesMapResponse;
import com.vlc2.academy.library.entity.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface BookService {

    BookResponse save(BookRequest request);
    BookResponse findById(Integer id);
    BookResponse findByName(String name);
    Book findBookByName(String name);
    Book getEntityByName(String name);
    List<BookResponse> findAll();
    Boolean existsByName(String name);
    void setValuesAfterSale(Book book);
    Boolean CheckStock(Book book, LocalDate date);
    void setValuesAfterOrder(Book book);
    SalesMapResponse rankByWeek(LocalDate day);
    SalesMapResponse rankByMonth(LocalDate day);
}
