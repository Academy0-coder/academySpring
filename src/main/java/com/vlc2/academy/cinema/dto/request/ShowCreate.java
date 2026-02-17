package com.vlc2.academy.cinema.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShowCreate {

    private LocalDateTime begin;
    private Integer theaterId;
    private Integer movieId;

}
