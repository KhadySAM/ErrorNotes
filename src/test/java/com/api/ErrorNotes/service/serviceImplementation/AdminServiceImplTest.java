package com.api.ErrorNotes.service.serviceImplementation;

import com.api.ErrorNotes.modele.*;
import com.api.ErrorNotes.repository.CompteRepository;
import com.api.ErrorNotes.repository.ProblemeRepository;
import com.api.ErrorNotes.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminServiceImplTest {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ProblemeRepository problemeRepository;

    @Autowired
    private CompteRepository compteRepository;

    @Test
    void creerEtat() {
        Etat etatTest = new Etat();
        etatTest.setNom("xxxxx");
        etatTest.setId(1L);

        adminService.creerEtat(etatTest, "ksamake18@gmail.com");
    }

    @Test
    void creerTechnologie(){
        Technologie technologieTest = new Technologie();

        Utilisateur utilisateurTest = new Utilisateur();

        technologieTest.setNom("ruby");
        technologieTest.setId(2L);
        adminService.creerTechnologie(technologieTest,"ksamake18@gmail.com");

    }

    @Test
    void supprimerCommentair() {
    }

    @Test
    void creerCompteAdmin() {
        Compte compte = new Compte();

        Utilisateur user = new Utilisateur();

        compte.setRole("admin");
        compte.setPassword("test1234567");
        compte.setId(1L);

        adminService.creerCompteAdmin(user,"ksamake18@gmail.com", "testadmin1234");

        Compte compteAd = compteRepository.save(compte);

    }

    @Test
    void trouverEtatparNom() {
    }
}