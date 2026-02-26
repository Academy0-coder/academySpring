package com.vlc2.academy.library.controller;

import com.vlc2.academy.library.command.OrderCommand;
import com.vlc2.academy.library.dto.response.OrderResponse;
import com.vlc2.academy.library.service.OrderService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final BeanFactory beanFactory;

    @GetMapping("/confirm")
    public ResponseEntity<OrderResponse> confirmOrder(@RequestParam Integer id){
        OrderCommand command = beanFactory.getBean(OrderCommand.class, orderService, id);
        return ResponseEntity.ok(command.execute());
    }

    @GetMapping()
    public ResponseEntity<List<OrderResponse>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/pending")
    public ResponseEntity<List<OrderResponse>> getPendingOrders(){
        return ResponseEntity.ok(orderService.getAllPending());
    }

}
