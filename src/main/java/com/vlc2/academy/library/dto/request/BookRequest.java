package com.vlc2.academy.library.dto.request;

import com.vlc2.academy.library.entity.Editor;
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
@AllArgsConstructor
public class BookRequest {

    private String name;
    private String author;
    private Integer year;
    private Double price;
    private Integer quantityInStock;
    private Integer threshold;
    private Integer restock;
    private String editor;
}
