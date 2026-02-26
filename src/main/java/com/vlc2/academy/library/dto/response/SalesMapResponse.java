package com.vlc2.academy.library.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;



// Dto that represents the list of books sold in a specific time span
// The map has book names as key and amount sold as value, the two local dates represent the beginning and the end of the time span
// This Dto is meant to be shown as a response


@Getter
@Setter
@AllArgsConstructor
public class SalesMapResponse {

    private final Map<String, Integer> books;
    private final LocalDate startDate;
    private final LocalDate endDate;

}
