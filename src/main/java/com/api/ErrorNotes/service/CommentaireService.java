package com.api.ErrorNotes.service;

import com.api.ErrorNotes.modele.Commentaire;

import java.util.List;

public interface CommentaireService {
    Commentaire ajouter(Commentaire commentaire);
    List<Commentaire> lire();
    String supprimer(Long id_commentaire);

    Commentaire ajouter();
}
