package com.vlc2.academy.library.dto.response;

import com.vlc2.academy.library.entity.Order;
import com.vlc2.academy.library.entity.Sale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Year;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

    private Integer id;
    private String name;
    private String author;
    private Year year;
    private BigDecimal price;
    private Integer quantitySold;
    private Integer quantityInStock;
    private Integer threshold;
    private Integer restock;
    private String editor;
    private List<Order> orders;
    private List<Sale> sales;
}
