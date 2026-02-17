package com.vlc2.academy.cinema.repository;

import com.vlc2.academy.cinema.entity.Theater;
import com.vlc2.academy.cinema.entity.Watcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheaterRepository extends JpaRepository<Theater,Integer> {

    @Query("SELECT EXISTS (SELECT 1 FROM Theater t)")
    Boolean isPresent();

    @Query(value = "SELECT * FROM movie_theater ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Optional<Theater> findLast();

}
