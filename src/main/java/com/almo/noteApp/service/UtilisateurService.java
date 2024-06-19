package com.almo.noteApp.service;

import com.almo.noteApp.entity.Utilisateur;
import com.almo.noteApp.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> getAllUtilisateurs() {
        List<Utilisateur> utilisateurList = utilisateurRepository.findAll();
        return utilisateurList;
    }

    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        Utilisateur utilisateurToCreate = utilisateurRepository.save(utilisateur);
        return utilisateurToCreate;
    }

    public String DeleteUtilisateurById(UUID utilisateurId) {
        Utilisateur utilisateurToDelete = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new RuntimeException("Cet utilisateur n'existe pas dans la BD"));
        utilisateurRepository.deleteById(utilisateurId);
        return "L'utilisateur avec ID : " + utilisateurId + " supprimé avec succès !";
    }

    public Utilisateur getUtilisateurById(UUID utilisateurId) {
        Utilisateur utilisateurToget = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new RuntimeException("Cet utilisateur n'existe pas dans la BD"));
        return utilisateurToget;
    }

    public Map<String, String> updateUtilisateurById(UUID utilisateurId, Utilisateur utilisateur) {
        Map<String, String> reponse = new HashMap<>();
        Optional<Utilisateur> existingUtilisateur = utilisateurRepository.findById(utilisateurId);
        if (!existingUtilisateur.isPresent()) {
            reponse.put("status", "failed");
            reponse.put("message", " l'utilisateur de Id " + utilisateurId + " nexiste pas ");
        } else {
            Utilisateur user = existingUtilisateur.get();
            user.setNomUtilisateur(utilisateur.getNomUtilisateur());
            user.setEmailUtilisateur(utilisateur.getEmailUtilisateur());
            user.setMotDePasseUtilisateur(utilisateur.getMotDePasseUtilisateur());
            utilisateurRepository.save(user);
            reponse.put("status", "succes");
            reponse.put("message", " l'utilisateur de Id " + utilisateurId + " a été mis à jour ");
        }
        return reponse;
    }
}
