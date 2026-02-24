package com.vlc2.academy.library.repository;

import com.vlc2.academy.library.entity.Book;
import com.vlc2.academy.library.entity.Editor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Optional<Book> findByName(String name);
}
