package com.almo.noteApp.repository;

import com.almo.noteApp.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NoteRepository extends JpaRepository<Note, UUID> {
 //   Note findByDescription(String noteDescription);
//    Note findByDate(LocalDateTime recDate);

}
