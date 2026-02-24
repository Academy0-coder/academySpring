package com.vlc2.academy.library.mapper;

import com.vlc2.academy.library.dto.response.OrderResponse;
import com.vlc2.academy.library.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderResponse toDto(Order order);

    List<OrderResponse> toDto(List<Order> orders);
}
