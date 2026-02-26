package com.vlc2.academy.library.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor


// Dto that represents a sale passed as a response
// This Dto is meant to be shown

public class SaleResponse {

    private Integer id;
    private Integer month;
    private Integer week;
    private String book;
}
