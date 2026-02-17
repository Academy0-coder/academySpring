package com.vlc2.academy.cinema.repository;

import com.vlc2.academy.cinema.entity.Show;
import com.vlc2.academy.cinema.entity.Watcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Show,Integer> {

    @Query("SELECT s FROM movie_show s ORDER BY s.id DESC LIMIT 1")
    Optional<Show> findLast();
}
