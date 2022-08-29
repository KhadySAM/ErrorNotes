package com.api.ErrorNotes.ServiceImpl;

import com.api.ErrorNotes.modele.Compte;
import com.api.ErrorNotes.repository.CommentaireRepository;
import com.api.ErrorNotes.repository.CompteRepository;
import com.api.ErrorNotes.service.CompteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class CompeServiceimpl implements CompteService {
    private final CompteRepository compteRepository;
    @Override
    public Compte connecter(Compte compte) {
        return null;
    }
}
