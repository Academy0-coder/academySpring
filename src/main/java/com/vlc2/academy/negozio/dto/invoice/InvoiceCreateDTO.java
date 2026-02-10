package com.vlc2.academy.negozio.dto.invoice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class InvoiceCreateDTO {

    private final Integer quantity;
    private final Integer customerId;
    private final Integer productId;


}
