package com.vlc2.academy.negozio.repository;

import com.vlc2.academy.negozio.entity.Customer;
import com.vlc2.academy.negozio.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("SELECT p FROM Product p ORDER BY p.price DESC")
    List<Product> orderByPrice();

    @Query("SELECT p FROM Product p ORDER BY p.price DESC LIMIT 1")
    Optional<Product> findMostExpensive();

    @Query("SELECT p FROM Product p ORDER BY p.quantitySold DESC")
    List<Product> orderByQuantitySold();

    @Query("SELECT p FROM Product p ORDER BY p.quantitySold DESC LIMIT 1")
    Optional<Product> findMostSold();

    List<Product> findByName (String name);


}
