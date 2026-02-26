package com.vlc2.academy.library.service.impl;

import com.vlc2.academy.library.dto.request.BookRequest;
import com.vlc2.academy.library.dto.response.BookResponse;
import com.vlc2.academy.library.dto.response.SalesMapResponse;
import com.vlc2.academy.library.entity.Book;
import com.vlc2.academy.library.entity.custom.BookCount;
import com.vlc2.academy.library.mapper.BookMapper;
import com.vlc2.academy.library.mapper.EditorMapper;
import com.vlc2.academy.library.mapper.OrderMapper;
import com.vlc2.academy.library.mapper.SaleMapper;
import com.vlc2.academy.library.repository.BookRepository;
import com.vlc2.academy.library.repository.EditorRepository;
import com.vlc2.academy.library.service.BookService;
import com.vlc2.academy.library.service.EditorService;
import com.vlc2.academy.library.service.OrderService;
import com.vlc2.academy.library.utility.DateUtility;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Getter
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final BookMapper mapper;

    private final EditorMapper editorMapper;
    private final EditorService editorService;

    @Override
    public BookResponse save(BookRequest request) {
        Book book = mapper.toEntity(request, editorService);
        repository.save(book);
        return mapper.toDto(book);
    }

    @Override
    public BookResponse findById(Integer id) {
        Optional<Book> book = repository.findById(id);
        return mapper.toDto(book.orElseThrow(
                () -> new EntityNotFoundException(String.format("There's no book with id: '%s'", id))));
    }

    @Override
    public BookResponse findByName(String name) {
        return mapper.toDto(findBookByName(name));
    }

    @Override
    public Book findBookByName(String name) {
        Optional<Book> book = repository.findByName(name);
        return book.orElseThrow(
                () -> new EntityNotFoundException(String.format("There's no book with name: '%s'", name)));
    }


    @Override
    public Book getEntityByName(String name) {
        Optional<Book> book = repository.findByName(name);
        return book.orElseThrow(
                () -> new EntityNotFoundException(String.format("There's no book with name: '%s'", name)));
    }


    @Override
    public List<BookResponse> findAll() {
        return mapper.listToDto(repository.findAll());
    }

    @Override
    public Boolean existsByName(String name) {
        return repository.findByName(name).isPresent();
    }


    @Override
    public Boolean CheckStock(Book book, LocalDate date) {
        return book.getQuantityInStock() + (repository.countByNameAndOrdersDeliveredIsFalse(book.getName())*book.getRestock()) <book.getThreshold();
    }

    @Override
    public void setValuesAfterSale(Book book) {
        book.setQuantitySold(book.getQuantitySold()+1);
        book.setQuantityInStock(book.getQuantityInStock()-1);
        repository.save(book);
    }

    @Override
    public void setValuesAfterOrder(Book book) {
        book.setQuantityInStock(book.getQuantityInStock()+book.getRestock());
        repository.save(book);
    }

    @Override
    public SalesMapResponse rankByWeek(LocalDate day) {

        Integer week = DateUtility.extractWeek(day);
        List<Book> books = repository.findByWeek(week);
        List<BookCount>  booksCount = new ArrayList<>();
        Map<String, Integer> result = new LinkedHashMap<>();

        for (Book book : books) {
            booksCount.add(new BookCount(book,repository.countBooksByWeek(book.getName(),week).intValue()));
        }

        booksCount = booksCount.stream().sorted(Comparator.comparing(BookCount::getCount).reversed()).collect(Collectors.toList());

        for (BookCount bookCount : booksCount) {
            result.put(bookCount.getBook().getName(),bookCount.getCount());
        }

        return new SalesMapResponse(result, DateUtility.firstDateOfWeek(day), DateUtility.lastDateOfWeek(day));
    }


    @Override
    public SalesMapResponse rankByMonth(LocalDate day) {

        Integer month = DateUtility.extractMonth(day);
        List<Book> books = repository.findByMonth(month);
        List<BookCount>  booksCount = new ArrayList<>();
        TreeMap<String, Integer> result = new TreeMap<>();

        for (Book book : books) {
            booksCount.add(new BookCount(book,repository.countBooksByMonth(book.getName(),month).intValue()));
        }

        booksCount = booksCount.stream().sorted(Comparator.comparing(BookCount::getCount).reversed()).collect(Collectors.toList());

        for (BookCount bookCount : booksCount) {
            result.put(bookCount.getBook().getName(),bookCount.getCount());
        }

        return new SalesMapResponse(result, DateUtility.firstDateOfMonth(day), DateUtility.lastDateOfMonth(day));
    }

}
