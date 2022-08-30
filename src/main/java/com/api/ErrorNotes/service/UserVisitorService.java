package com.api.ErrorNotes.service;

import com.api.ErrorNotes.modele.*;

import java.util.List;

public interface UserVisitorService {

        Utilisateur creerCompteUser(Utilisateur utilisateur, String email, String password);

        List<Probleme> lireProbleme();

        List<Commentaire> lireCommentaire();

        List<Solution> lireSolution();

        List<Technologie> lireTechnologie();

}
