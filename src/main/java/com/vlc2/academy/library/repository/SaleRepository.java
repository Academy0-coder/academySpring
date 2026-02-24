package com.vlc2.academy.library.repository;

import com.vlc2.academy.library.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
