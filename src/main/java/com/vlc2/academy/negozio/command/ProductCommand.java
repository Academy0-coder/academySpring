package com.vlc2.academy.negozio.command;

import com.vlc2.academy.negozio.dto.product.ProductCreateDTO;
import com.vlc2.academy.negozio.dto.product.ProductReadDTO;
import com.vlc2.academy.negozio.service.ProductService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Getter
@Setter
@RequiredArgsConstructor
public class ProductCommand {
    private final ProductService productService;
    private final ProductCreateDTO dto;

    public void execute(){
        if (canExecute()){
            doExecute();
        }
    }

    private boolean canExecute(){
        return !((dto.getName() == null || dto.getName().isBlank())
                || (dto.getPrice() == null || dto.getPrice() <= 0)
                || (dto.getQuantityInStock() == null || dto.getQuantityInStock() <= 0));
    }

    private void doExecute(){
        productService.createProduct(dto);
    }

}
