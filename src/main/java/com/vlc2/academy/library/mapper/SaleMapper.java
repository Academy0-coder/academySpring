package com.vlc2.academy.library.mapper;

import com.vlc2.academy.library.dto.response.SaleResponse;
import com.vlc2.academy.library.entity.Sale;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    SaleResponse toDto(Sale sale);

    List<SaleResponse> toDto(List<Sale> sales);
}
