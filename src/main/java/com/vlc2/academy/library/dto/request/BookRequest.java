package com.vlc2.academy.library.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


// Dto that represents a book passed as a request
// This Dto is only meant for creation of new records

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
