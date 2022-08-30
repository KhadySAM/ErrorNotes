package com.api.ErrorNotes.controller;

import com.api.ErrorNotes.modele.*;
import com.api.ErrorNotes.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
@AllArgsConstructor

public class UserController {

    private final UtilisateurService utilisateurService;

    @PostMapping("/ajouter")
    public Probleme ajouter_Un_Probleme(@RequestBody Probleme probleme) {
        return utilisateurService.ajouter_Un_Probleme(probleme);
    }

    @PostMapping("/ajouter")
    public Solution ajouter_Une_Solution(@RequestBody Solution solution) {
        return utilisateurService.ajouter_Une_Solution(solution);

    }

    @PostMapping("/commenter")
    public Commentaire faire_un_Commentaire(@RequestBody Commentaire commentaire) {
        return utilisateurService.faire_un_Commentaire(commentaire);
    }

    @PostMapping("/creer")
    public Compte creer_Un_Compte(@RequestBody Compte compte) {
        return utilisateurService.creer_Un_Compte(compte);
    }
}
