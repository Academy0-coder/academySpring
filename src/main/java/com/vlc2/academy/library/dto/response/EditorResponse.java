package com.vlc2.academy.library.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;



// Dto that represents an editor passed as a response
// This Dto is meant to be shown

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
