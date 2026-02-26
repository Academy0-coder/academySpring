package com.vlc2.academy.library.service.impl;

import com.vlc2.academy.library.dto.request.BookRequest;
import com.vlc2.academy.library.dto.response.BookResponse;
import com.vlc2.academy.library.entity.Book;
import com.vlc2.academy.library.mapper.BookMapper;
import com.vlc2.academy.library.mapper.EditorMapper;
import com.vlc2.academy.library.repository.BookRepository;
import com.vlc2.academy.library.service.BookService;
import com.vlc2.academy.library.service.EditorService;
import com.vlc2.academy.library.utility.GeneralUtility;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Getter
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final BookMapper mapper;

    private final EditorMapper editorMapper;
    private final EditorService editorService;

    // -----------------------------
    // Methods that operate on the level of database (CRUD Methods)
    // -----------------------------
    @Override
    public void save(Book book) {
        repository.save(book);
    }

    @Override
    public Book findById(Integer id) {
        Optional<Book> book = repository.findById(id);
        return GeneralUtility.getValueOfAnOptional(book, "book", "id", id);
    }

    @Override
    public Book findByName(String name) {
        Optional<Book> book = repository.findByName(name);
        return GeneralUtility.getValueOfAnOptional(book, "book", "name", name);
    }


    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    // Method that checks whether a book is present or not
    @Override
    public Boolean existsByName(String name) {
        return repository.findByName(name).isPresent();
    }


    // Method that checks whether a re stock is needed or not
    @Override
    public Boolean CheckStock(Book book, LocalDate date) {
        return book.getQuantityInStock() + (repository.countByNameAndOrdersDeliveredIsFalse(book.getName())*book.getRestock()) <book.getThreshold();
    }

    // Method that update the number of books in stock after a book has been sold
    @Override
    public void setValuesAfterSale(Book book) {
        book.setQuantitySold(book.getQuantitySold()+1);
        book.setQuantityInStock(book.getQuantityInStock()-1);
        repository.save(book);
    }

    // Method that update the number of books in stock after an order has been delivered
    @Override
    public void setValuesAfterOrder(Book book) {
        book.setQuantityInStock(book.getQuantityInStock()+book.getRestock());
        repository.save(book);
    }


    /**
     * @param request
     * @return BookResponse
     * General method for saving a new record
     */
    @Override
    public BookResponse insert(BookRequest request) {
        Book book = mapper.toEntity(request, editorService);
        save(book);
        return mapper.toDto(book);
    }

    /**
     * @param id
     * @return BookResponse
     * General method for searching a book by id
     */
    @Override
    public BookResponse getBookById(Integer id) {
        Book book = findById(id);
        return mapper.toDto(book);
    }

    /**
     * @param name
     * @return BookResponse
     * General method for searching a book by name
     */
    @Override
    public BookResponse getBookByName(String name) {
        Book book = findByName(name);
        return mapper.toDto(book);
    }

    /**
     * @return List of BookResponse
     */
    @Override
    public List<BookResponse> getAllBooks() {
        return mapper.listToDto(findAll());
    }

}
