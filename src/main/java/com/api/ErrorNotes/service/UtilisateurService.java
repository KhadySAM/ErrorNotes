package com.api.ErrorNotes.service;

import com.api.ErrorNotes.modele.Commentaire;
import com.api.ErrorNotes.modele.Compte;
import com.api.ErrorNotes.modele.Probleme;
import com.api.ErrorNotes.modele.Solution;

public interface UtilisateurService {
    // les méthodes de user
    Probleme ajouter_Un_Probleme (Probleme probleme);

    Solution ajouter_Une_Solution(Solution solution);

    Commentaire faire_un_Commentaire(Commentaire commentaire);

    Compte creer_Un_Compte (Compte compte);



}
