package com.vlc2.academy.negozio.dto.invoice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;

@RequiredArgsConstructor
@Getter
@Setter
public class InvoiceReadDTO {

    private final Integer id;
    private final Integer quantity;
    private final String customerName;
    private final String customerSurname;
    private final String product;
    private final Instant timestamp;
    private final BigDecimal taxable;
    private final BigDecimal total;

    public InvoiceReadDTO(Integer id, Integer quantity, String customerName, String customerSurname, String product, Double price, Instant timestamp){
        this.id = id;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.product = product;
        this.quantity = quantity;
        this.timestamp = timestamp;
        taxable = BigDecimal.valueOf(quantity*price).setScale(2, RoundingMode.HALF_UP);
        total = BigDecimal.valueOf(quantity*price*1.22).setScale(2, RoundingMode.HALF_UP);
    }


}
