package com.vlc2.academy.library.repository;

import com.vlc2.academy.library.entity.Editor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EditorRepository extends JpaRepository<Editor, Integer> {

    Optional<Editor> findByName(String name);
    Optional<Editor> findByEmail(String email);

}
