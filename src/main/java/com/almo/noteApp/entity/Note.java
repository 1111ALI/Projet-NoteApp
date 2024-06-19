package com.almo.noteApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Note")
@Table(name = "notes")

public class Note {
    @Id
    @GeneratedValue

    private UUID noteId;
    private String noteDescription;
    private String noteBody;
    private LocalDate recDate;
    private String noteReminder;

}
