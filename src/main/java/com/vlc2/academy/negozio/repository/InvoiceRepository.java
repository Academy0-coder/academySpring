package com.vlc2.academy.negozio.repository;

import com.vlc2.academy.negozio.entity.Invoice;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT i FROM Invoice i WHERE i.timestamp BETWEEN :start AND :end")
    List<Invoice> findInATimeSpan(Instant start, Instant end);

    @Transactional(readOnly = true)
    @Query("SELECT i FROM Invoice i WHERE i.customer.id = :id ")
    List<Invoice> findAllByCustomerId(Integer id);

    @Transactional(readOnly = true)
    @Query("SELECT i FROM Invoice i WHERE i.product.id = :id ")
    List<Invoice> findAllByProductId(Integer id);


}
