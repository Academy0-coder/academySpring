package com.vlc2.academy.library.dto.response;

import com.vlc2.academy.library.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

    private Integer id;
    private LocalDate day;
    private Boolean delivered;
    private Book book;
}
