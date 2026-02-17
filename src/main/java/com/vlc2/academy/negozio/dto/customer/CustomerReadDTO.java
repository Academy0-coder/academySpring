package com.vlc2.academy.negozio.dto.customer;

import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
public class CustomerReadDTO {

    private final Integer id;
    private final String name;
    private final String surname;

    public boolean equals(CustomerReadDTO check){
        return getName().equals(check.getName())&&getSurname().equals(check.getSurname());
    }
}
