package com.vlc2.academy.cinema.repository;

import com.vlc2.academy.cinema.entity.Watcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WatcherRepository extends JpaRepository<Watcher,Integer> {

    @Query("SELECT c FROM Customer c ORDER BY c.id DESC LIMIT 1")
    Optional<Watcher> findLast();

}
