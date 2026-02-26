package com.vlc2.academy.library.mapper;

import com.vlc2.academy.library.dto.response.OrderResponse;
import com.vlc2.academy.library.entity.Book;
import com.vlc2.academy.library.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {






    // --------------------------------
    // ENTITY MAPPERS
    // --------------------------------
    // From Entity To Dto
    OrderResponse toDto(Order order);

    // From a List of Entities to a List of Dtos
    List<OrderResponse> listToDto(List<Order> orders);






    // --------------------------------
    // DEFAULT MAPPERS
    // --------------------------------
    // From a Book to a String (Their names)
    default String bookToString (Book book) {
        return book.getName();
    }

}
