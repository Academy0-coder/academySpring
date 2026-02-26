package com.vlc2.academy.library.entity.custom;

import com.vlc2.academy.library.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;


// Support Entity used to simplify the build of the map that tracks the number of copies of books sold in a specific time span

@AllArgsConstructor
@Getter
public class BookCount {

    private final Book book;
    private final Integer count;

}
