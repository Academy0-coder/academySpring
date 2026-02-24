package com.vlc2.academy.library.dto.response;

import com.vlc2.academy.library.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EditorResponse {

    private Integer id;
    private String name;
    private BigDecimal averageTimeDelivering;
    private String email;
    private List<BookResponse> books;
}
