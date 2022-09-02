package com.api.ErrorNotes.controller;

import com.api.ErrorNotes.modele.*;
import com.api.ErrorNotes.service.UserVisitorService;
import com.api.ErrorNotes.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visiteur")
@AllArgsConstructor
public class UserVisitorController {

    @Autowired
    final private UserVisitorService userVisitorService;

    @Autowired
    final private UtilisateurService utilisateurService;

    @PostMapping("/creerCompte")//{email}/{password}
    public String creerCompte(@RequestBody Utilisateur utilisateur){

        if(utilisateurService.trouverCompteParEmail(utilisateur.getCompte().getEmail()) == null){
            if(utilisateur.getCompte().getEmail().trim().equals("") || utilisateur.getCompte().getPassword().trim().equals("")){
                return "Veuillez remplir les champs obligatoire";
            }else {
                if (utilisateur.getCompte().getPassword().length() >= 10){
                    userVisitorService.creerCompteUser(utilisateur, utilisateur.getCompte().getEmail(), utilisateur.getCompte().getPassword());
                    return "Compte est créée avec succes";
                }else{
                    return "Le mot de passe doit être superieur à 10 caracteurs";
                }

            }
        }else {
            return "Cet email existe déjà";
        }
    }


    @GetMapping("/afficheProb")
    public List<Probleme> readProbleme(){

        return  userVisitorService.lireProbleme();
    }

    @GetMapping("/afficherSolution")
    public List<Solution> readSolution(){

        return userVisitorService.lireSolution();
    }

    @GetMapping("/afficherCommentaire")
    public List<Commentaire> readCommentaire(){

        return userVisitorService.lireCommentaire();
    }


}


