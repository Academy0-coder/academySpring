package com.vlc2.academy.library.service;

import com.vlc2.academy.library.dto.request.SaleRequest;
import com.vlc2.academy.library.dto.response.SaleResponse;
import com.vlc2.academy.library.dto.response.SalesMapResponse;
import com.vlc2.academy.library.entity.Sale;

import java.time.LocalDate;
import java.util.List;

public interface SaleService {

    void save(Sale sale);
    Sale findById(Integer id);
    List<Sale> findAll();
    Boolean existsByBook(String name);

    SaleResponse insert(SaleRequest request);
    SaleResponse getSaleById(Integer id);
    List<SaleResponse> getAllSales();

    SalesMapResponse rankByWeek(LocalDate day);
    SalesMapResponse rankByMonth(LocalDate day);


}
