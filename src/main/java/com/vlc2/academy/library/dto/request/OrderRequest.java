package com.vlc2.academy.library.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

// Dto that represents an order passed as a request
// This Dto is only meant for switching the state delivered from false to true
// It is used when you confirm an order has been delivered

@Getter
@Setter
@AllArgsConstructor
public class OrderRequest {

    Integer id;
    LocalDate date;
}
