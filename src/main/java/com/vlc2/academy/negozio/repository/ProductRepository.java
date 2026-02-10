package com.vlc2.academy.negozio.repository;

import com.vlc2.academy.negozio.entity.Customer;
import com.vlc2.academy.negozio.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("SELECT p FROM Product p WHERE p.name = :name")
    Optional<Product> findByName (String name);

}
