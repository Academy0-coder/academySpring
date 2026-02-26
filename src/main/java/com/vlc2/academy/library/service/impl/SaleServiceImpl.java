package com.vlc2.academy.library.service.impl;

import com.vlc2.academy.library.dto.request.SaleRequest;
import com.vlc2.academy.library.dto.response.SaleResponse;
import com.vlc2.academy.library.dto.response.SalesMapResponse;
import com.vlc2.academy.library.entity.Book;
import com.vlc2.academy.library.entity.Sale;
import com.vlc2.academy.library.entity.custom.BookCount;
import com.vlc2.academy.library.exception.custom.SoldOutException;
import com.vlc2.academy.library.mapper.SaleMapper;
import com.vlc2.academy.library.repository.BookRepository;
import com.vlc2.academy.library.repository.SaleRepository;
import com.vlc2.academy.library.service.BookService;
import com.vlc2.academy.library.service.OrderService;
import com.vlc2.academy.library.service.SaleService;
import com.vlc2.academy.library.utility.DateUtility;
import com.vlc2.academy.library.utility.GeneralUtility;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Getter
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final SaleRepository repository;
    private final SaleMapper mapper;

    private final OrderService orderService;
    private final BookService bookService;
    private final BookRepository bookRepository;



    // -----------------------------
    // Methods that operate on the level of database (CRUD Methods)
    // -----------------------------
    @Override
    public void save(Sale sale) {
        repository.save(sale);
    }

    @Override
    public Sale findById(Integer id) {
        Optional<Sale> sale = repository.findById(id);
        return GeneralUtility.getValueOfAnOptional(sale, "sale", "id", id);
    }

    @Override
    public List<Sale> findAll() {
        return repository.findAll();
    }


    // Method that serves to check if the book inserted exists or not
    @Override
    public Boolean existsByBook(String name) {
        return bookRepository.findByName(name).isPresent();
    }


    /**
     * @param request
     * @return SaleResponse
     * General method for saving a new record
     */
    @Override
    public SaleResponse insert(SaleRequest request) {

        // Throw exception if there's no copy of the book requested left
        if(bookService.findByName(request.getBook()).getQuantityInStock()==0){
            throw new SoldOutException(String.format("%s books are out of stock",request.getBook()));
        }

        // save the new sale on the database
        // therefore updates the value of the quantity of books and checks if a new order needs to be requested
        Sale sale = mapper.toEntity(request, bookService);
        save(sale);
        orderService.executeOrderCheck(request.getBook(),request.getDate());
        return mapper.toDto(sale);
    }


    /**
     * @param id
     * @return SaleResponse
     * General method for retrieving a sale by id
     */
    @Override
    public SaleResponse getSaleById(Integer id) {
        Sale sale = findById(id);
        return mapper.toDto(sale);
    }

    /**
     * @return List of all sales
     */
    @Override
    public List<SaleResponse> getAllSales() {
        return mapper.listToDto(findAll());
    }


    /**
     * @param day
     * @return SalesMapResponse
     * Method that retrieves the list of books in decreasing order by sales for a specific week
     */
    @Override
    public SalesMapResponse rankByWeek(LocalDate day) {

        // Get the week number and the list of books which has been sold at least once that week
        // The week is based on the date passed
        Integer week = DateUtility.extractWeek(day);
        List<Book> books = bookRepository.findBySalesWeek(week);
        List<BookCount>  booksCount = new ArrayList<>();
        Map<String, Integer> result = new LinkedHashMap<>();

        // Save a list of bookCounts each of which is made by a book and the integer that represents the copies sold
        for (Book book : books) {
            booksCount.add(new BookCount(book,bookRepository.countByNameAndSalesWeek(book.getName(),week).intValue()));
        }

        // Sort the list by number of copies sold
        booksCount = booksCount.stream().sorted(Comparator.comparing(BookCount::getCount).reversed()).collect(Collectors.toList());

        // Fill the linkedHashMap with the values of the bookCounts
        for (BookCount bookCount : booksCount) {
            result.put(bookCount.getBook().getName(),bookCount.getCount());
        }

        // Return a SalesMapResponse with the map built and the ends of the week considered
        return new SalesMapResponse(result, DateUtility.firstDateOfWeek(day), DateUtility.lastDateOfWeek(day));
    }



    /**
     * @param day
     * @return SalesMapResponse
     * Method that retrieves the list of books in decreasing order by sales for a specific month
     */
    @Override
    public SalesMapResponse rankByMonth(LocalDate day) {

        // Get the month number and the list of books which has been sold at least once that month
        // The month is based on the date passed
        Integer month = DateUtility.extractMonth(day);
        List<Book> books = bookRepository.findBySalesMonth(month);
        List<BookCount>  booksCount = new ArrayList<>();
        TreeMap<String, Integer> result = new TreeMap<>();

        // Save a list of bookCounts each of which is made by a book and the integer that represents the copies sold
        for (Book book : books) {
            booksCount.add(new BookCount(book,bookRepository.countByNameAndSalesMonth(book.getName(),month).intValue()));
        }

        // Sort the list by number of copies sold
        booksCount = booksCount.stream().sorted(Comparator.comparing(BookCount::getCount).reversed()).collect(Collectors.toList());

        // Fill the linkedHashMap with the values of the bookCounts
        for (BookCount bookCount : booksCount) {
            result.put(bookCount.getBook().getName(),bookCount.getCount());
        }

        // Return a SalesMapResponse with the map built and the ends of the month considered
        return new SalesMapResponse(result, DateUtility.firstDateOfMonth(day), DateUtility.lastDateOfMonth(day));
    }



}
