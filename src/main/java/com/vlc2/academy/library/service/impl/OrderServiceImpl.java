package com.vlc2.academy.library.service.impl;

import com.vlc2.academy.library.dto.response.OrderResponse;
import com.vlc2.academy.library.entity.Book;
import com.vlc2.academy.library.entity.Order;
import com.vlc2.academy.library.exception.custom.InvalidOrderException;
import com.vlc2.academy.library.mapper.OrderMapper;
import com.vlc2.academy.library.repository.OrderRepository;
import com.vlc2.academy.library.service.BookService;
import com.vlc2.academy.library.service.OrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Getter
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final OrderMapper mapper;

    private final BookService bookService;

    @Override
    public void createOrder(Book book, LocalDate day) {
        Order order = new Order(day, false, book);
        save(order);
    }

    @Override
    public void executeOrder(String bookName, LocalDate date) {
        Book book = bookService.findBookByName(bookName);
        bookService.setValuesAfterSale(book);
        if(bookService.CheckStock(book, date)){
            createOrder(book, date);
        }
    }

    @Override
    public OrderResponse confirmOrder(Integer id) {
        Order order = repository.findById(id).orElseThrow(() -> new InvalidOrderException(String.format("There's no order with id: %d",id)));
        if(order.getDelivered()){
            throw new InvalidOrderException(String.format("Order number %d has already been delivered",id));
        }
        order.setDelivered(true);
        save(order);
        bookService.setValuesAfterOrder(order.getBook());
        return mapper.toDto(order);

    }

    @Override
    public Boolean existsById(Integer id) {
        return repository.existsById(id);
    }


    @Override
    public OrderResponse findById(Integer id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new InvalidOrderException(String.format("There's no order with id: %d",id))));
    }

    @Override
    public List<OrderResponse> getAll() {
        return mapper.listToDto(repository.findAll());
    }

    @Override
    public List<OrderResponse> getAllPending() {
        return mapper.listToDto(repository.findByDeliveredIsFalse());
    }

    @Override
    public void save(Order order) {
        repository.save(order);
    }

}
