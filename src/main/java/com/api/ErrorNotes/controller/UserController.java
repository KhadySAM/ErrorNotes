package com.api.ErrorNotes.controller;


import com.api.ErrorNotes.modele.*;
import com.api.ErrorNotes.repository.SolutionRepository;
import com.api.ErrorNotes.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {


    @Autowired
    final private UtilisateurService utilisateurService;

    @Autowired
    final private SolutionRepository solutionRepository;



    @PostMapping("/createProbleme/{email}/{password}/{tech}")
    public String createProbleme(@RequestBody Probleme probleme, @PathVariable String email, @PathVariable String password, @PathVariable String tech) {

        //authentification
        if (utilisateurService.connexion(email, password)) {

            //verifie si le titre mis à l'url a un problème correspondant
            if (utilisateurService.trouverProblemeParTitre(probleme.getTitre()) == null) {

                //recupere le compte par email
                Compte utilisateurCompte = utilisateurService.trouverCompteParEmail(email);

                System.out.println(utilisateurCompte);

                //recupere l'user correspondant au compte ci-dessus
                Utilisateur user = utilisateurService.trouverUtilisateurParCompte(utilisateurCompte);

                //Un tableau qui contiendra une technologie par case
                String[] techTab = tech.split(":");
                System.out.println("Les technologies mises" + techTab);

                //Initialisation de la liste qui contenera la liste des technologies à enregistrer
                List<ProblemeAvoirTechnologie> listProTechno = new ArrayList<>();

                //ce boolean est utilisé pour verifier si tous les technologies precisées par l'user existe ou pas dans la base
                boolean bool = true;

                //cette boucle sert à parcours les noms des technologies pour recuper
                // les technologies correspondantes afin de les ajouter à la list à de type problemes_technologie
                //qui sera en fin enregistré

                for (String t : techTab) {

                    //Instaciation de la classe Probleme_technologies, utilisé pour stocker aléatoirement
                    //les problemes_technologies recuperer
                    ProblemeAvoirTechnologie proTechno = new ProblemeAvoirTechnologie();

                    //recuperation aléatoire des technologies
                    Technologie techno = utilisateurService.trouverTechonologieParNom(t);

                    //On met la valeur de la variable bool à false lorsqu'une tecnologie sera introuvable dans la base
                    if (techno == null) {
                        bool = false;
                    }

                    //On attribue la technologie actuelle à proTechno
                    proTechno.setTechnologie(techno);

                    //On attribue le probleme à proTechno
                    proTechno.setProbleme(probleme);

                    //ajout de problemes_technologie formé à la list à retourner
                    listProTechno.add(proTechno);

                }
                if (bool == true) {//on verifie si toutes les technologies ont été retrouvé dans la base

                    //on crée le probleme en lui attribuant l'user actuel
                    utilisateurService.creerProbleme(probleme, user);

                    //repositoryProblemeTechnologie.saveAll(listProTechno);
                    utilisateurService.enregistrerProblemesTechnologies(listProTechno);
                    return "Probleme enregistré avec succes";
                } else {
                    return "Une des technologie n'existe pas";
                }
            } else {
                return "Ce problème existe déjà veuillez lire la solution";
            }
        } else {
            return "Acces refusé";
        }
    }

    @PostMapping("/createSolution/{email}/{password}/{titreProbleme}/{ressources}")
    public String createSolution(@RequestBody Solution solution, @PathVariable String email, @PathVariable String password, @PathVariable String titreProbleme, @PathVariable String ressources) {

        //recupere le probleme sur lequel la solution doit etre  posté
        Probleme prob = utilisateurService.trouverProblemeParTitre(titreProbleme);

        //on verifie si le problème existe ou pas
        if (prob != null) {
            //recuperation de l'id du problème
            Long idPro = prob.getId();
            System.err.println(idPro);
            //recupere l'id de l'utilisateur qui a posté le problème
            Long id_userProbleme = utilisateurService.trouverProblemeParId(idPro).getUtilisateur().getId();

            //Recuperation du compte de l'utilisateur qui veut resoudre le problème par son email
            Compte compte_user = utilisateurService.trouverCompteParEmail(email);

            //recuperation de l'id de l'user qui veut poster une solution
            Long id_userSolution = utilisateurService.trouverUtilisateurParCompte(compte_user).getId();

            System.err.println(id_userSolution);
            System.err.println(id_userProbleme);


            //si email et password de l'user sont correct
            if (utilisateurService.connexion(email, password) && id_userProbleme.equals(id_userSolution)) {

                Probleme pro = utilisateurService.trouverProblemeParTitre(titreProbleme);
                Solution sol = solutionRepository.findByProbleme(pro);

                //verfie si le probleme specifié a une solution ou pas
                if (pro != null && sol == null) {

                    //creation de la solution
                    Solution solutionCree = utilisateurService.creerSolution(solution, prob);

                    //list permettant de stocker les resource dans l'objectif de les enregister tous en même temps
                    List<Ressource> ressourceList = new ArrayList<>();

                    //Un tableau qui contenera les ressources par case
                    String[] tabRessources = ressources.split(":");


                    //Sert à parcours les ressources envoyées pour les recuper
                    //et les ajouter un à un, à  la list ressourcesList à l'aide de l'instance de ressource appélé
                    //ress
                    for (String r : tabRessources) {

                        //instance de ressource
                        Ressource ress = new Ressource();

                        //attribue le lien doc actuel à ress actuel
                        ress.setLiens(r);

                        //on atribue la solution à ress actuelle
                        ress.setSolution(solutionCree);

                        //on stocke ress actuel à ressourceList, la liste à enregistré
                        ressourceList.add(ress);
                    }

                    //enregistrement des different ressources
                    utilisateurService.enregistrerRessource(ressourceList);

                    return "Solution enregistré avec succes";

                } else {//si le problème a déjà une solution

                    return "Ce probleme a été déjà resolu";
                }
            } else {//authentification echoué ou problème n' pas été posté par l'utilisateur
                return "Acces refusé";
            }
        } else {//Si le problème n'existe pas
            return "Ce problème n'existe pas";
        }
    }

    @PostMapping("/createCommentaire/{email}/{password}/{titreProbleme}")
    public String createCommentaire(@RequestBody Commentaire commentaire, @PathVariable String
            email, @PathVariable String password, @PathVariable String titreProbleme) {

        if (utilisateurService.connexion(email, password)) {

            Probleme probleme = utilisateurService.trouverProblemeParTitre(titreProbleme);
            Solution solution = solutionRepository.findByProbleme(probleme);

            if (probleme != null && solution != null) {

                Long idProbleme = probleme.getId();

                System.err.println(idProbleme);

                Long idSolu = solution.getIds();
                System.err.println(idSolu);

                Compte compteUser = utilisateurService.trouverCompteParEmail(email);

                Utilisateur user = utilisateurService.trouverUtilisateurParCompte(compteUser);


                utilisateurService.creerCommentaire(commentaire, user, solution);
                return "Commentaire enregistré avec succes";
            } else {
                return "On ne peut pas commenter une solution qui n'existe pas";
            }
        } else {
            return "Erreur d'authentification";
        }

    }

}


