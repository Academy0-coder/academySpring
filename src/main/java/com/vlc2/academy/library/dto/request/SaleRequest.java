package com.vlc2.academy.library.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

// Dto that represents a sale passed as a request
// This Dto is only meant for creation of new records

@Getter
@Setter
@AllArgsConstructor
public class SaleRequest {

    private LocalDate date;
    private String book;

}
