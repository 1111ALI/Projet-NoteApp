package com.almo.noteApp.repository;

import com.almo.noteApp.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository

public interface UtilisateurRepository extends JpaRepository<Utilisateur, UUID > {
}
