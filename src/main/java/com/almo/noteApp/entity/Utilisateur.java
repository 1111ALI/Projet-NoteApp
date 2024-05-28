package com.almo.noteApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Utilisateur")
@Table(name = "utilisateur")
@Builder
public class Utilisateur {
    @Id
    @GeneratedValue
private UUID utilisateurId;
private String nomUtilisateur;
private String emailUtilisateur;
private String motDePasseUtilisateur;
}
