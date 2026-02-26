package com.vlc2.academy.library.service.impl;

import com.vlc2.academy.library.dto.request.EditorRequest;
import com.vlc2.academy.library.dto.request.SaleRequest;
import com.vlc2.academy.library.dto.response.EditorResponse;
import com.vlc2.academy.library.dto.response.SaleResponse;
import com.vlc2.academy.library.dto.response.SalesMapResponse;
import com.vlc2.academy.library.entity.Book;
import com.vlc2.academy.library.entity.Editor;
import com.vlc2.academy.library.entity.Sale;
import com.vlc2.academy.library.exception.custom.SoldOutException;
import com.vlc2.academy.library.mapper.SaleMapper;
import com.vlc2.academy.library.repository.SaleRepository;
import com.vlc2.academy.library.service.BookService;
import com.vlc2.academy.library.service.OrderService;
import com.vlc2.academy.library.service.SaleService;
import com.vlc2.academy.library.utility.DateUtility;
import com.vlc2.academy.negozio.exceptions.customExceptions.OutOfStock;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Getter
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final SaleRepository repository;
    private final SaleMapper mapper;

    private final OrderService orderService;
    private final BookService bookService;

    @Override
    public SaleResponse save(SaleRequest request) {
        if(bookService.findBookByName(request.getBook()).getQuantityInStock()==0){
            throw new SoldOutException(String.format("%s books are out of stock",request.getBook()));
        }
        Sale sale = mapper.toEntity(request, bookService);
        repository.save(sale);
        orderService.executeOrder(request.getBook(),request.getDate());
        return mapper.toDto(sale);
    }


    @Override
    public SaleResponse findById(Integer id) {
        Optional<Sale> sale = repository.findById(id);
        return mapper.toDto(sale.orElseThrow(
                () -> new EntityNotFoundException(String.format("There's no sale with id: '%s'", id))));
    }

    @Override
    public List<SaleResponse> findAll() {
        return mapper.listToDto(repository.findAll());
    }

    @Override
    public Boolean existsByBook(String name) {
        return bookService.existsByName(name);
    }


    @Override
    public SalesMapResponse rankByWeek(LocalDate day) {

        return bookService.rankByWeek(day);
    }


    @Override
    public SalesMapResponse rankByMonth(LocalDate day) {

        return bookService.rankByMonth(day);
    }

}
