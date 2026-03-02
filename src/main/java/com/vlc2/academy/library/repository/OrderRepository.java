package com.vlc2.academy.library.repository;

import com.vlc2.academy.library.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {



    // Query that retrieves all the orders which have not been delivered yet
    List<Order> findByDeliveredIsFalse();

    // Query the retrieves the day an order has been launched by passing its id
    @Query(value = "SELECT o.dayOrder FROM Order o WHERE o.id = :id")
    Optional<LocalDate> getDayOrder(Integer id);

    // Get the list of delivered orders of a specific editor (by passing their name)
    List<Order> findByDeliveredIsTrueAndBookEditorName(String name);

    // Get the list of pending orders of a specific day
    List <Order> findByDayOrderAndDeliveredIsFalse(LocalDate date);
}
