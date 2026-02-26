package com.vlc2.academy.library.dto.response;

import com.vlc2.academy.library.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SaleResponse {

    private Integer id;
    private Integer month;
    private Integer week;
    private String book;
}
