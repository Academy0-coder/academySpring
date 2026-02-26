package com.vlc2.academy.library.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class SalesMapResponse {

    private final Map<String, Integer> books;
    private final LocalDate startDate;
    private final LocalDate endDate;

}
