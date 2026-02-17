package com.vlc2.academy.negozio.mapper;

import com.vlc2.academy.negozio.dto.customer.CustomerReadDTO;
import com.vlc2.academy.negozio.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CustomerMapperTest {

    CustomerMapper mapper = new CustomerMapper();

    @Test
    void toDTO() {
        CustomerReadDTO customerDTO = new CustomerReadDTO(1, "a", "c");
        Customer customer = new Customer("a", "c");
        CustomerReadDTO check = mapper.toDTO(customer);
        Assertions.assertTrue(customerDTO.equals(check));
    }

    @Test
    void listToDto() {
        List<Customer> custS = List.of(new Customer("a","b"),new Customer("c","d"));
        List<CustomerReadDTO> custDTO = List.of(new CustomerReadDTO(1,"a","b"),new CustomerReadDTO(2,"c","d"));
        List<CustomerReadDTO> check = mapper.ListToDTO(custS);
        boolean equality = custDTO.size()==check.size();
        for(int i = 0; i< custDTO.size(); i++){
            equality = equality && (custDTO.get(i).equals(check.get(i)));
        }
        Assertions.assertTrue(equality);
    }
}