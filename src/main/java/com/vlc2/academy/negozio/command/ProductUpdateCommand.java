package com.vlc2.academy.negozio.command;

import com.vlc2.academy.negozio.dto.product.ProductCreateDTO;
import com.vlc2.academy.negozio.dto.product.ProductReadDTO;
import com.vlc2.academy.negozio.dto.product.ProductUpdateDTO;
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
public class ProductUpdateCommand {

    private final ProductService productService;
    private final ProductUpdateDTO productUpdateDTO;

    public ProductReadDTO execute(){
        if (canExecute()){
            return doExecute();
        }
        return null;
    }

    private boolean canExecute(){
        return !((productUpdateDTO.getId() == null || productUpdateDTO.getId() <= 0)
                || (productUpdateDTO.getQuantity() == null || productUpdateDTO.getQuantity() <= 0));
    }

    private ProductReadDTO doExecute(){
        return productService.updateProduct(productUpdateDTO);
    }
}
