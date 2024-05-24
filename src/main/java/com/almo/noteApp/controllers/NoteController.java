package com.almo.noteApp.controllers;

import com.almo.noteApp.entity.Note;
import com.almo.noteApp.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/notes/")
public class NoteController {
    private final NoteService noteService;

    // Recuperer toutes les Notes de la Table notes dans la BD
    @GetMapping("get-all")
    public List<Note> getAllNote() {
        return noteService.getAllNote();
    }

    // Enregistrement d'une Note
    @PostMapping("create")
    public Note createNote(@RequestBody Note note) {
        return noteService.createNote(note);
    }

    // Supprimer une Note
    @DeleteMapping("{id}")
    public String deleteNoteById(@PathVariable("id") UUID noteId) {
        return noteService.deleteNoteById(noteId);
    }

    // Chercher un Note par son Id
    @GetMapping("{id}")
    public Note getNoteById(@PathVariable("id") UUID noteId) {
        return noteService.getNoteById(noteId);

    }
    // Chercher une Note par sa Description
//    @GetMapping("{noteDescription}")
//    public Note getNoteByDescription(@PathVariable ("noteDescription") String noteDescription){
//        return noteService.getNoteByDescription(noteDescription);
//
//    }

    // Mettre à jour une note
    @PutMapping("{id}")
    public Note updateNoteById (@PathVariable("id") UUID noteId, @RequestBody Note note){
        return noteService.updateNoteById(noteId, note);

    }
}
