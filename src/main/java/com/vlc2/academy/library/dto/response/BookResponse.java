package com.vlc2.academy.library.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Year;


// Dto that represents a book passed as a response
// This Dto is meant to be shown

@Getter
@Setter
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
}
