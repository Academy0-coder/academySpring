package com.vlc2.academy.library.repository;

import com.vlc2.academy.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Optional<Book> findByName(String name);

    Long countByNameAndOrdersDeliveredIsFalse(String name);

    @Query("SELECT b FROM Book b JOIN Sale s ON b.id = s.book.id WHERE s.week = :week")
    List<Book> findByWeek(Integer week);

    @Query("SELECT b FROM Book b JOIN Sale s ON b.id = s.book.id WHERE s.month = :month")
    List<Book> findByMonth(Integer month);

    @Query("SELECT COUNT (b) FROM Book b JOIN Sale s ON b.id = s.book.id WHERE b.name = :name AND s.week = :week")
    Long countBooksByWeek(String name, Integer week);

    @Query("SELECT COUNT (b) FROM Book b JOIN Sale s ON b.id = s.book.id WHERE b.name = :name AND s.month = :month")
    Long countBooksByMonth(String name, Integer month);
}
