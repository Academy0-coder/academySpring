package com.vlc2.academy.library.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class EditorResponse {

    private Integer id;
    private String name;
    private BigDecimal averageTimeDelivering;
    private String email;
    private List<BookResponse> books;
}
