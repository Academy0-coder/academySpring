package com.vlc2.academy.library.service;

import com.vlc2.academy.library.dto.response.OrderResponse;
import com.vlc2.academy.library.entity.Book;
import com.vlc2.academy.library.entity.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {

    void save(Order order);
    void createOrder(Book book, LocalDate date);
    void executeOrder(String book, LocalDate date);
    OrderResponse confirmOrder(Integer id);
    Boolean existsById(Integer id);
    OrderResponse findById(Integer id);
    List<OrderResponse> getAll();
    List<OrderResponse> getAllPending();

}
