package com.api.ErrorNotes.service;

import com.api.ErrorNotes.modele.Technologie;

import java.util.List;

public interface TechnologieService {
    Technologie soumettre(Technologie technologie);
    List<TechnologieService> lire();

}
