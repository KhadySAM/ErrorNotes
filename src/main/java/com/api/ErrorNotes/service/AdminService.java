package com.api.ErrorNotes.service;

import com.api.ErrorNotes.modele.Etat;
import com.api.ErrorNotes.modele.Technologie;
import com.api.ErrorNotes.modele.Utilisateur;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    Etat creerEtat(Etat etat, String email);

    Technologie creerTechnologie(Technologie technologie, String email);

    String supprimerCommentair(Long id_commentaire);

    Utilisateur creerCompteAdmin(Utilisateur utilisateur, String email, String password);

    Etat TrouverEtatparNom(String nom);



    }


