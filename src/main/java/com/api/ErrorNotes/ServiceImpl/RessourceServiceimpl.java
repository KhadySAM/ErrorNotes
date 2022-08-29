package com.api.ErrorNotes.ServiceImpl;

import com.api.ErrorNotes.modele.Ressource;
import com.api.ErrorNotes.repository.RessourceRepository;
import com.api.ErrorNotes.service.RessourceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class RessourceServiceimpl implements RessourceService {
    private final RessourceRepository ressourceRepository;
    @Override
    public Ressource ajouter(Ressource ressource) {
        return null;
    }

    @Override
    public String supprimer(Long id_ressource) {
        return null;
    }
}
