package com.vlc2.academy.cinema.repository;

import com.vlc2.academy.cinema.entity.Movie;
import com.vlc2.academy.cinema.entity.Watcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    @Query("SELECT EXISTS (SELECT 1 FROM Movie m)")
    Boolean isPresent();

    @Query(value = "SELECT * FROM movie ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Optional<Movie> findLast();

    @Query("SELECT COUNT(m) FROM Movie m")
    Integer countAll();

}
