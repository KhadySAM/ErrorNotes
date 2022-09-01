package com.api.ErrorNotes.service.serviceImplementation;

import com.api.ErrorNotes.modele.Probleme;
import com.api.ErrorNotes.modele.Technologie;
import com.api.ErrorNotes.modele.Utilisateur;
import com.api.ErrorNotes.repository.ProblemeRepository;
import com.api.ErrorNotes.service.UtilisateurService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UtilisateurServiceImplTest {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private ProblemeRepository problemeRepository;

    @Test
    void creerProbleme() {
        Technologie tech = new Technologie();

        tech.setNom("java");
        Probleme creerProb = new Probleme();
        creerProb.setTitre("test titre 1");
        creerProb.setDescription("description test");


    }

    @Test
    void creerSolution() {
    }

    @Test
    void creerCommentaire() {
    }

    @Test
    void connexion() {
    }

    @Test
    void trouverProblemeParTitre() {
    }

    @Test
    void trouverSolutionParIdProbleme() {
    }

    @Test
    void trouverCompteParEmail() {
    }

    @Test
    void trouverProblemeParId() {
    }

    @Test
    void trouverUtilisateurParCompte() {
    }

    @Test
    void enregistrerProblemesTechnologies() {
    }

    @Test
    void trouverTechonologieParNom() {
    }

    @Test
    void enregistrerRessource() {
    }
}