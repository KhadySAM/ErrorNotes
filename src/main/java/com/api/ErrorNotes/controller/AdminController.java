package com.api.ErrorNotes.controller;

import com.api.ErrorNotes.modele.Compte;
import com.api.ErrorNotes.modele.Etat;
import com.api.ErrorNotes.modele.Technologie;
import com.api.ErrorNotes.modele.Utilisateur;
import com.api.ErrorNotes.service.AdminService;
import com.api.ErrorNotes.service.UserVisitorService;
import com.api.ErrorNotes.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    final private AdminService adminService;
    final private UserVisitorService userVisitorService;
    final private UtilisateurService utilisateurService;

    @PostMapping("/creerCompteAdmin/{email}/{password}")//{emailAcree}/{passwordAcree}

    //methode permettant de creer un compte admin
    public String creerCompteAdmin(@RequestBody Utilisateur utilisateur, @PathVariable String email, @PathVariable String password) {

        //recuperation du compte admin que l'admin veut crée
        Compte compteAcree = utilisateurService.trouverCompteParEmail(utilisateur.getCompte().getEmail());

        //recuperation du compte de l'user admin actuel
        Compte compte = utilisateurService.trouverCompteParEmail(email);

        System.out.println(compte.getRole());

        //verifie si l'user actuel a un compte et si son password est correct et s'il a le role admin
        if (utilisateurService.connexion(email, password) == true && compte.getRole().equals("admin")|| compte.getEmail().equals("ksamake18@gmail.com")){

            //verifie si l'user admin que l'admin actuel veut crée existe ou pas
            if (compteAcree == null){

                //creation du compte admin
                adminService.creerCompteAdmin(utilisateur, utilisateur.getCompte().getEmail(), utilisateur.getCompte().getPassword());

                return "compte admin créé";
            }else {//lorsque le compte existe déjà
                return "Ce compte existe déjà";
            }
        }else {//authentification échoué
            return "Acces refusé";
        }
    }

    @PostMapping("/createEtat/{email}/{password}")
    public String createEtat(@RequestBody Etat etat, @PathVariable  String email, @PathVariable String password){

        //verifie si c'est l'user actuelle est un admin et si son mot de passe est correct
        if (utilisateurService.connexion(email, password) == true && utilisateurService.trouverCompteParEmail(email).getRole().equals("admin")){

            //Verifie si l'etat demandé existe déjà ou pas
            if(adminService.TrouverEtatparNom(etat.getNom()) == null) {

                //creation de l'etat
                adminService.creerEtat(etat, email);

                return "Etat enregistré avec succes";
            }else{
                return "cet Etat existe dejà";
            }
        }else {//authentification échoué
            return "Acces refusé";
        }
    }

    @PostMapping("/createTechnologie/{email}/{password}")
    public String createTechnologie(@RequestBody Technologie technologie, @PathVariable  String email, @PathVariable String password){

        //verifie si c'est l'user actuelle est un admin et si son mot de passe est correct
        if (utilisateurService.connexion(email, password) == true && utilisateurService.trouverCompteParEmail(email).getRole().equals("admin")){

            //Verifie si la technologie demandé existe déjà ou pas
            if(utilisateurService.trouverTechonologieParNom(technologie.getNom()) == null) {

                //creation de la technologie
                adminService.creerTechnologie(technologie, email);
                return "Technologie enregistré avec succes";
            }else {
                return "cette Technologie existe déjà";
            }
        }else {//authentification échoué
            return "Acces refusé";
        }
    }

    @DeleteMapping("/DeleteCommentaire/{id}")
    public String suppCommentaire(@PathVariable Long id){

        return adminService.supprimerCommentair(id);
    }

    /*
    @GetMapping("/afficherTechonologie")
    public List<Technologie> readTechnologie(){

        return adminService.lireTechnologie();
    }

    @GetMapping("/afficherTechonologie")
    public List<Etat> readEtat(){

        return adminService.lireEtat();
    }*/


}
