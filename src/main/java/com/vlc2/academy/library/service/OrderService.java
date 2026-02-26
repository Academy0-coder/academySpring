package com.vlc2.academy.library.service;

import com.vlc2.academy.library.dto.request.OrderRequest;
import com.vlc2.academy.library.dto.response.OrderResponse;
import com.vlc2.academy.library.entity.Book;
import com.vlc2.academy.library.entity.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {

    void save(Order order);
    Order findById(Integer id);
    List<Order> findAll();
    List<Order> findAllPending();
    void createOrder(Book book);
    void executeOrderCheck(String book, LocalDate date);
    Boolean existsById(Integer id);
    LocalDate getDayOrder (Integer id);


    OrderResponse confirmOrder(OrderRequest order);
    OrderResponse getOrderById(Integer id);
    List<OrderResponse> getAll();
    List<OrderResponse> getAllPending();

}
