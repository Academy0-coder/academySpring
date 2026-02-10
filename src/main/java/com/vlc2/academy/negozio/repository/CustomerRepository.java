package com.vlc2.academy.negozio.repository;

import com.vlc2.academy.negozio.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query("SELECT c FROM Customer c WHERE c.name = :name AND c.surname = :surname")
    Optional<Customer> findByNameSurname (String name, String surname);
}
