package com.vlc2.academy.library.populating;

import com.vlc2.academy.library.dto.request.OrderRequest;
import com.vlc2.academy.library.dto.request.SaleRequest;
import com.vlc2.academy.library.entity.Order;
import com.vlc2.academy.library.service.BookService;
import com.vlc2.academy.library.service.OrderService;
import com.vlc2.academy.library.service.SaleService;
import com.vlc2.academy.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
@ConditionalOnProperty(name = "populate", havingValue = "true")
@RequiredArgsConstructor
public class PopulatingService {


    // This class is a service with a method meant to populate the database quite randomly of sales and orders.
    // It is useful to test to functionality of api related to sales and orders since it avoids to insert a bunch of records manually.


    private final SaleService saleService;
    private final BookService bookService;
    private final OrderService orderService;


    public void populate(){

        Map<Order,LocalDate> trackOrders = new HashMap<>();
        Integer avgSales = 0;
        Integer actualSales = 0;


        // Cycle each day from 9 months ago to 3 months from now. All the records will be stored in this time span
        for(LocalDate date =  LocalDate.now().minusMonths(9); date.isBefore(LocalDate.now().plusMonths(3)); date = date.plusDays(1)){
            if(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY){
                avgSales = 10;
            }
            else{ avgSales = 5;}

            // Uses Poisson distribution to determine the number of sales on a specific day supposing that the average number of sales is 10 on weekends and 5 on other days
            actualSales = Utils.randomPoissonQuantile(avgSales);


            // For each sale extract a random book and perform the sale
            for(int i = 0; i < actualSales; i++){
                saleService.insert(new SaleRequest(date, bookService.findById(Utils.randomNumber(20)).getName()));
            }

            // For each order that has been generated on the current date extract randomly with a Poisson distribution
            // the number of days for the delivery supposing an average of 5 days and put the value on the map trackOrders.
            for(Order order : orderService.findAllPendingByDay(date)){
                Integer shippingDays = Utils.randomPoissonQuantile(5);
                trackOrders.put(order,date.plusDays(shippingDays));
            }

            // For each order that should be delivered today confirms such order
            for(Order order : trackOrders.keySet()){
                if(trackOrders.get(order).equals(date)){
                    orderService.confirmOrder(new OrderRequest(order.getId(),trackOrders.get(order)));
                }
            }

        }

    }

}
