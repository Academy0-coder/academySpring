package com.vlc2.academy.library.entity.custom;

import com.vlc2.academy.library.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookCount {

    private final Book book;
    private final Integer count;

}
