package com.api.ErrorNotes.service;

import com.api.ErrorNotes.modele.Probleme;

public interface ProblemeService {
    Probleme soumettre(Probleme probleme);
    Probleme rechercher(Probleme probleme);

}
