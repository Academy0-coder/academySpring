package com.vlc2.academy.cinema.repository;

import com.vlc2.academy.cinema.entity.Movie;
import com.vlc2.academy.cinema.entity.Watcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    @Query("SELECT m FROM movie m ORDER BY m.id DESC LIMIT 1")
    Optional<Movie> findLast();

}
