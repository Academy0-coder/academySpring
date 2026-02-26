package com.vlc2.academy.library.repository;

import com.vlc2.academy.library.entity.Book;
import com.vlc2.academy.library.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByDeliveredIsFalse();
}
