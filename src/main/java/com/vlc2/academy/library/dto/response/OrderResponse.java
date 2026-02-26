package com.vlc2.academy.library.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor



// Dto that represents an order passed as a response
// This Dto is meant to be shown


public class OrderResponse {

    private Integer id;
    private LocalDate dayOrder;
    private LocalDate dayDeliver;
    private Boolean delivered;
    private String book;
}
