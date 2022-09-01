package com.api.ErrorNotes.service;

import com.api.ErrorNotes.modele.*;
import com.api.ErrorNotes.repository.ProblemeAvoirTechnologieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UtilisateurService {

    Probleme creerProbleme(Probleme probleme, Utilisateur user);

    Solution creerSolution(Solution solution, Probleme prob);

    Commentaire creerCommentaire(Commentaire commentaire, Utilisateur user, Solution solution);

    Boolean connexion(String email, String password);

    Probleme trouverProblemeParTitre(String titre);

   Solution trouverSolutionParIdProbleme(Long problemeId);

    Compte trouverCompteParEmail(String email);

    Probleme trouverProblemeParId(Long id);

    Utilisateur trouverUtilisateurParCompte(Compte compte);

    List<ProblemeAvoirTechnologie> enregistrerProblemesTechnologies(List<ProblemeAvoirTechnologie> protechnologie);

    Technologie trouverTechonologieParNom(String nom);

    List<Ressource> enregistrerRessource(List<Ressource> ressources);

}
