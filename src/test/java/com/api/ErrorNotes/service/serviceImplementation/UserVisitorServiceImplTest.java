package com.api.ErrorNotes.service.serviceImplementation;

import com.api.ErrorNotes.modele.Compte;
import com.api.ErrorNotes.modele.Utilisateur;
import com.api.ErrorNotes.repository.CompteRepository;
import com.api.ErrorNotes.repository.ProblemeRepository;
import com.api.ErrorNotes.repository.UtilisateurRepository;
import com.api.ErrorNotes.service.UserVisitorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserVisitorServiceImplTest {

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private UserVisitorService userVisitorService;

    @Autowired
    private ProblemeRepository problemeRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Test
    void creerCompteUser() {
        Compte compteUser = new Compte();
        Utilisateur user = new Utilisateur();
        user = utilisateurRepository.findById(1L).get();
        compteUser.setEmail("kmahamadou858@gmail.com");
        compteUser.setPassword("lllllllllll");
        compteUser.setRole("user");
        userVisitorService.creerCompteUser(user, "ksamake18@gmail.com", "testadmin12");
       // Compte userC = compteRepository.save(compteUser);



    }

    @Test
    void lireProbleme() {
    }

    @Test
    void lireCommentaire() {
    }

    @Test
    void lireSolution() {
    }
}