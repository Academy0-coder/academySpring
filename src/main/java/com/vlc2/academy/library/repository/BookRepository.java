package com.vlc2.academy.library.repository;

import com.vlc2.academy.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    // Query that get a book by name (since names are unique the return is an optional)
    Optional<Book> findByName(String name);

    // Query that retrieves the number of orders not delivered yet of a specific book
    Long countByNameAndOrdersDeliveredIsFalse(String name);

    // Query that retrieves the list of books which have been sold at least once on a specific week
    List<Book> findBySalesWeek (Integer week);

    // Query that retrieves the list of books which have been sold at least once on a specific month
    List<Book> findBySalesMonth(Integer month);

    // Query that counts how many copies of a book have been sold in a week
    Long countByNameAndSalesWeek(String name, Integer week);

    // Query that counts how many copies of a book have been sold in a month
    Long countByNameAndSalesMonth(String name, Integer month);
}
