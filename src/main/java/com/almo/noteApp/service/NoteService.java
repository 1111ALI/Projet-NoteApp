package com.almo.noteApp.service;

import com.almo.noteApp.entity.Note;
import com.almo.noteApp.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;


    public List<Note> getAllNote() {
        List<Note> noteList = noteRepository.findAll();
        return noteList;
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public String deleteNoteById(UUID noteId) {
        Note noteToBeDelete = noteRepository.findById(noteId)
                .orElseThrow(()->new RuntimeException("cette note n'existe pas dans la BD"));
        noteRepository.deleteById(noteId);
        return "La Note avec ID : " + noteId + " supprimé avec succès !";
    }

    public Note getNoteById(UUID noteId) {
        Note noteToGet = noteRepository.findById(noteId)
                .orElseThrow(()->new RuntimeException("cette note n'existe pas dans la BD"));
        return noteToGet;
    }

    public Note updateNoteById(UUID noteId, Note note) {
        Note existingNote = noteRepository.findById(noteId)
                .orElseThrow(()->new RuntimeException("cette note n'existe pas dans la BD"));
        existingNote.setNoteDescription(note.getNoteDescription());
        existingNote.setNoteBody(note.getNoteBody());
        existingNote.setRecDate(note.getRecDate());
        existingNote.setNoteReminder(note.getNoteReminder());

        return noteRepository.save(existingNote);
    }

    public Note getNoteByDescription(String noteDescription) {
        Note noteByDescription = noteRepository.findByNoteDescription(noteDescription);
        return noteRepository.findByNoteDescription(noteDescription);

    }

    public Note getNoteByDate(LocalDateTime recDate) {
        Note noteByDate = noteRepository.findByRecDate(recDate);
        return noteRepository.findByRecDate(recDate);
    }
}
