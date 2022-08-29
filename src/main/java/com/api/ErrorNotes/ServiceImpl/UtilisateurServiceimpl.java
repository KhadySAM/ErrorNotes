package com.api.ErrorNotes.ServiceImpl;

import com.api.ErrorNotes.modele.Utilisateur;
import com.api.ErrorNotes.repository.UtilisateurRepository;
import com.api.ErrorNotes.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class UtilisateurServiceimpl implements UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;
    @Override
    public Utilisateur crer(Utilisateur User) {
        return null;
    }
}
