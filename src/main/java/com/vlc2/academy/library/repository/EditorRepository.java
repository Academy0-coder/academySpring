package com.vlc2.academy.library.repository;

import com.vlc2.academy.library.entity.Editor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EditorRepository extends JpaRepository<Editor, Integer> {

    // Query that get an editor by name (since names are unique the return is an optional)
    Optional<Editor> findByName(String name);

    // Query that get an editor by email (since emails are unique the return is an optional)
    Optional<Editor> findByEmail(String email);

}
