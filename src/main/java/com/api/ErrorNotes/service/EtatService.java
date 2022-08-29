package com.api.ErrorNotes.service;

import com.api.ErrorNotes.modele.Etat;

import java.util.List;

public interface EtatService {
    Etat ajouter(Etat etat);
    List lire(Etat etat);
    Etat modifier(Long id_etat, Etat etat);
    String supprimer(Long id_etat);
}
