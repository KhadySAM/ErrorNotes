package com.api.ErrorNotes.ServiceImpl;

import com.api.ErrorNotes.modele.Commentaire;
import com.api.ErrorNotes.repository.CommentaireRepository;
import com.api.ErrorNotes.service.CommentaireService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class CommentaireServiceimpl implements CommentaireService {
    private final CommentaireRepository commentaireRepository;

    @Override
    public Commentaire ajouter(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);

    }

    @Override
    public List<Commentaire> lire() {
        return null;

    }

    @Override
    public String supprimer(Long id_commentaire) {
        return null;
    }

    @Override
    public Commentaire ajouter() {
        return null;
    }
}
