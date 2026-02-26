package com.vlc2.academy.library.repository;

import com.vlc2.academy.library.entity.Editor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EditorRepository extends JpaRepository<Editor, Integer> {

    Optional<Editor> findByName(String name);
    Optional<Editor> findByEmail(String email);

}
