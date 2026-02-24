package com.vlc2.academy.library.repository;

import com.vlc2.academy.library.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
