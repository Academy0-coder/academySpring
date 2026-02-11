package com.vlc2.academy.negozio.repository;

import com.vlc2.academy.negozio.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT p FROM Product p ORDER BY p.price DESC")
    List<Product> orderByPrice();

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.quantity = :quantity WHERE p.id = :id")
    void update(Integer id, Integer quantity);

}
