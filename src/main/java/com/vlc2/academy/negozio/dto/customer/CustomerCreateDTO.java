package com.vlc2.academy.negozio.dto.customer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class CustomerCreateDTO {

    private final String name;
    private final String surname;

}
