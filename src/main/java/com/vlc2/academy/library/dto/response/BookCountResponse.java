package com.vlc2.academy.library.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


// Dto meant to register books and the number of copies sold in a time span. It's meant to be stored in a SalesMapResponse

@Getter
@Setter
@AllArgsConstructor
public class BookCountResponse {

    private final String book;
    private final Integer count;

}
