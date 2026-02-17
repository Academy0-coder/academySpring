package com.vlc2.academy.cinema.repository;

import com.vlc2.academy.cinema.entity.Theater;
import com.vlc2.academy.cinema.entity.Watcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheaterRepository extends JpaRepository<Theater,Integer> {

    @Query("SELECT t FROM movie_theater t ORDER BY t.id DESC LIMIT 1")
    Optional<Theater> findLast();

}
