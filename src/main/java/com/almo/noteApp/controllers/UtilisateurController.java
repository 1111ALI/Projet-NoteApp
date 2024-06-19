package com.almo.noteApp.controllers;

import com.almo.noteApp.entity.Utilisateur;
import com.almo.noteApp.service.UtilisateurService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/utilisateurs/")
public class UtilisateurController {
    private final UtilisateurService utilisateurService;

// Recuperer toutes les Utilisateurs de la Table utilisateur dans la BD
    @GetMapping("get-all")
    public List<Utilisateur> getAllUtilisateurs (){
        return utilisateurService.getAllUtilisateurs();
    }
    // Enregistrement d'un Utilisateur
    @PostMapping("create")
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurService.createUtilisateur(utilisateur);

    }
    // Supprimer un utilisateur par son Id
    @DeleteMapping("{id}")
    public String DeleteUtilisateurById(@PathVariable("id") UUID utilisateurId){
        return utilisateurService.DeleteUtilisateurById(utilisateurId);

    }
    // Chercher un utilisateur par son Id
    @GetMapping("{id}")
    public Utilisateur getUtilisateurById (@PathVariable("id") UUID utilisateurId){
        return utilisateurService.getUtilisateurById(utilisateurId);

    }
    // Mettre à jour un utilisateur
    @PutMapping("{id}")
    public Map <String, String> updateUtilisateurById (@PathVariable("id") UUID utilisateurId, @RequestBody Utilisateur utilisateur) {
        return utilisateurService.updateUtilisateurById(utilisateurId,utilisateur);
    }

}
