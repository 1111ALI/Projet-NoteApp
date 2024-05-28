package com.almo.noteApp.service;

import com.almo.noteApp.entity.Utilisateur;
import com.almo.noteApp.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public Utilisateur updateUtilisateurById(UUID utilisateurId, Utilisateur utilisateur) {
        Utilisateur existingUtilisateur = utilisateurRepository.findById(utilisateurId)

                .orElseThrow(() -> new RuntimeException("Cet utilisateur n'existe pas dans la BD"));

        //       if(!studentRepository.existsById(existingStudent.getStudentId())){
//if ( utilisateurRepository.existsById(existingUtilisateur.getUtilisateurId())){
//            throw new RuntimeException("Utilisateur inexistant dnas la BD");
//        }

        existingUtilisateur.setNomUtilisateur(utilisateur.getNomUtilisateur());
        existingUtilisateur.setEmailUtilisateur(utilisateur.getEmailUtilisateur());
        existingUtilisateur.setMotDePasseUtilisateur(utilisateur.getMotDePasseUtilisateur());
        return utilisateurRepository.save(existingUtilisateur);
    }
}
