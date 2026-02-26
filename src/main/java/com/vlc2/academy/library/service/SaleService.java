package com.vlc2.academy.library.service;

import com.vlc2.academy.library.dto.request.SaleRequest;
import com.vlc2.academy.library.dto.response.SaleResponse;
import com.vlc2.academy.library.dto.response.SalesMapResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface SaleService {

    SaleResponse save(SaleRequest request);
    SaleResponse findById(Integer id);
    List<SaleResponse> findAll();
    Boolean existsByBook(String name);
    SalesMapResponse rankByWeek(LocalDate day);
    SalesMapResponse rankByMonth(LocalDate day);


}
