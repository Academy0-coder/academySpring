package com.vlc2.academy.library.service.impl;

import com.vlc2.academy.library.dto.request.OrderRequest;
import com.vlc2.academy.library.dto.response.OrderResponse;
import com.vlc2.academy.library.entity.Book;
import com.vlc2.academy.library.entity.Order;
import com.vlc2.academy.library.exception.custom.InvalidOrderException;
import com.vlc2.academy.library.mapper.OrderMapper;
import com.vlc2.academy.library.repository.OrderRepository;
import com.vlc2.academy.library.service.BookService;
import com.vlc2.academy.library.service.EditorService;
import com.vlc2.academy.library.service.OrderService;
import com.vlc2.academy.library.utility.GeneralUtility;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@Getter
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final OrderMapper mapper;

    private final BookService bookService;
    private final EditorService editorService;


    // -----------------------------
    // Methods that operate on the level of database (CRUD Methods)
    // -----------------------------
    @Override
    public void save(Order order) {
        repository.save(order);
    }



    @Override
    public void createOrder(Book book) {
        Order order = new Order(null, false, book);
        save(order);
    }


    @Override
    public Order findById(Integer id) {
        Optional<Order> order = repository.findById(id);
        return GeneralUtility.getValueOfAnOptional(order, "order", "id", id);
    }


    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }


    @Override
    public List<Order> findAllPending() {
        return repository.findByDeliveredIsFalse();
    }


    // Method that is called within a sale insertion
    // It checks if a re stock is needed. If such, it creates a new order request
    @Override
    public void executeOrderCheck(String bookName, LocalDate date) {
        Book book = bookService.findByName(bookName);
        bookService.setValuesAfterSale(book);
        if(bookService.CheckStock(book, date)){
            createOrder(book);
        }
    }


    // Method that is called everytime an order is delivered
    @Override
    public OrderResponse confirmOrder(OrderRequest request) {

        // If there's no order by that id or the order has already been delivered throw an exception
        Order order = GeneralUtility.getValueOfAnOptional(repository.findById(request.getId()), "order", "id", request.getId());
        if(order.getDelivered()){
            throw new InvalidOrderException(String.format("Order number %d has already been delivered",request.getId()));
        }

        // Updates the values of the order and then save it
        order.setDelivered(true);
        order.setDayDeliver(request.getDate());
        save(order);

        // Updates the values of number in stock for the books and average time delivering for the editor
        bookService.setValuesAfterOrder(order.getBook());
        Integer daysDeliver = ((Long) ChronoUnit.DAYS.between(order.getDayOrder(), order.getDayDeliver())).intValue();
        Integer editor = order.getBook().getEditor().getId();
        editorService.setValuesAfterOrder(daysDeliver, editor);
        return mapper.toDto(order);

    }


    // Method that checks whether an order exists by id
    @Override
    public Boolean existsById(Integer id) {
        return repository.existsById(id);
    }


    // Method that retrieves the day in which a specific order was requested
    @Override
    public LocalDate getDayOrder(Integer id) {
        return GeneralUtility.getValueOfAnOptional(repository.getDayOrder(id),"order", "id", id);
    }


    /**
     * @param id
     * @return OrderResponse
     * General method for finding an order by id
     */
    @Override
    public OrderResponse getOrderById(Integer id) {
        return mapper.toDto(findById(id));
    }


    /**
     * @return List of Order Response
     * General method for retrieving all orders
     */
    @Override
    public List<OrderResponse> getAll() {
        return mapper.listToDto(findAll());
    }


    /**
     * @return List of Order Response
     * General method for retrieving all pending orders
     */
    @Override
    public List<OrderResponse> getAllPending() {
        return mapper.listToDto(findAllPending());
    }



}
