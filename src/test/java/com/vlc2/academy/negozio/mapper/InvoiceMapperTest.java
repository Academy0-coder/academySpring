package com.vlc2.academy.negozio.mapper;

import com.vlc2.academy.negozio.dto.invoice.InvoiceReadDTO;
import com.vlc2.academy.negozio.entity.Customer;
import com.vlc2.academy.negozio.entity.Invoice;
import com.vlc2.academy.negozio.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class InvoiceMapperTest {

    InvoiceMapper mapper = new InvoiceMapper();
    Instant inst1 = Instant.now().minusSeconds(3000);
    Instant inst2 = Instant.now().minusSeconds(5000);
    Customer cust1 = new Customer("Mario","Rossi");
    Customer cust2 = new Customer("Luigi","Verdi");
    Product prod1 = new Product("Bistecche",1.11,5);
    Product prod2 = new Product("Salmoni",2.22,6);

    @Test
    void toDTO() {
        InvoiceReadDTO invoiceDTO = new InvoiceReadDTO(1,3,"Mario","Rossi","Bistecche",1.11, inst1);
        Invoice invoice = new Invoice(3,cust1,prod1,inst1);
        InvoiceReadDTO check = mapper.toDTO(invoice);
        Assertions.assertTrue(invoiceDTO.equals(check));
    }

    @Test
    void listToDto() {
        List<Invoice> invoS = List.of(new Invoice(3,cust1,prod1,inst1),new Invoice(4,cust2,prod2,inst2));
        List<InvoiceReadDTO> invoDTO = List.of(new InvoiceReadDTO(1,3,"Mario","Rossi","Bistecche",1.11, inst1),
                new InvoiceReadDTO(2,4,"Luigi","Verdi","Salmoni", 2.22,inst2));
        List<InvoiceReadDTO> check = mapper.toDTO(invoS);
        boolean equality = invoDTO.size()==check.size();
        for(int i = 0; i< invoDTO.size(); i++){
            equality = equality && (invoDTO.get(i).equals(check.get(i)));
        }
        Assertions.assertTrue(equality);
    }
}