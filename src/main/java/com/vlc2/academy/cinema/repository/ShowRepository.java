package com.vlc2.academy.cinema.repository;

import com.vlc2.academy.cinema.entity.Show;
import com.vlc2.academy.cinema.entity.Theater;
import com.vlc2.academy.cinema.entity.Watcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Show,Integer> {

    @Query("SELECT EXISTS (SELECT 1 FROM Show s)")
    Boolean isPresent();

    @Query(value = "SELECT * FROM movie_show ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Optional<Show> findLast();

    Optional<Show> findFirstByTheaterAndBeginOrderByBeginDesc(Theater theater, LocalDateTime chosenTime);

    @Query("SELECT COUNT(s) FROM Show s")
    Integer countAll();
}
