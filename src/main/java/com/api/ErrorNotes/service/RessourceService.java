package com.api.ErrorNotes.service;

import com.api.ErrorNotes.modele.Ressource;

public interface RessourceService {
    Ressource ajouter(Ressource ressource);
    String supprimer(Long id_ressource);
}
