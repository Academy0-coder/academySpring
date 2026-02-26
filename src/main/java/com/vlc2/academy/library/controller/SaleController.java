package com.vlc2.academy.library.controller;

import com.vlc2.academy.library.command.SaleCommand;
import com.vlc2.academy.library.command.SalesMapCommand;
import com.vlc2.academy.library.dto.request.SaleRequest;
import com.vlc2.academy.library.dto.response.SaleResponse;
import com.vlc2.academy.library.dto.response.SalesMapResponse;
import com.vlc2.academy.library.service.SaleService;
import com.vlc2.academy.library.utility.StringUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sale")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService service;
    private final BeanFactory beanFactory;

    @PostMapping
    public ResponseEntity<SaleResponse> carryOutSale(@RequestBody SaleRequest sale) {

        sale.setBook(StringUtility.capitalizeFirst(sale.getBook()));
        SaleCommand command = beanFactory.getBean(SaleCommand.class, service, sale);
        return ResponseEntity.ok(command.execute());
    }

    @GetMapping()
    public ResponseEntity<List<SaleResponse>> getAllSales() {

        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleResponse> getSaleById(@PathVariable Integer id) {

        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/rank/week")
    public ResponseEntity<SalesMapResponse> getWeeklySales(@RequestParam LocalDate day) {
        SalesMapCommand  command = beanFactory.getBean(SalesMapCommand.class, service, day);
        return ResponseEntity.ok(command.executeWeek());
    }

    @GetMapping("/rank/month")
    public ResponseEntity<SalesMapResponse> getMonthlySales(@RequestParam LocalDate day) {
        SalesMapCommand  command = beanFactory.getBean(SalesMapCommand.class, service, day);
        return ResponseEntity.ok(command.executeMonth());
    }

}
