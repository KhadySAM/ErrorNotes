package com.api.ErrorNotes.ServiceImpl;

import com.api.ErrorNotes.modele.Etat;
import com.api.ErrorNotes.repository.EtatRepository;
import com.api.ErrorNotes.service.EtatService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class EtatServiceimpl implements EtatService {
    private final EtatRepository etatRepository;
    @Override
    public Etat ajouter(Etat etat) {
        return null;
    }

    @Override
    public List lire(Etat etat) {
        return null;
    }

    @Override
    public Etat modifier(Long id_etat, Etat etat) {
        return null;
    }

    @Override
    public String supprimer(Long id_etat) {
        return null;
    }
}
