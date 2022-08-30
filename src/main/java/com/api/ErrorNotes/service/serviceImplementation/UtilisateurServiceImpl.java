package com.api.ErrorNotes.service.serviceImplementation;

import com.api.ErrorNotes.modele.Commentaire;
import com.api.ErrorNotes.modele.Compte;
import com.api.ErrorNotes.modele.Probleme;
import com.api.ErrorNotes.modele.Solution;
import com.api.ErrorNotes.repository.*;
import com.api.ErrorNotes.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final ProblemeRepository problemeRepository;
    private final SolutionRepository solutionRepository;
    private final CommentaireRepository commentaireRepository;
    private final CompteRepository compteRepository;

    @Override
    public Probleme ajouter_Un_Probleme(Probleme probleme) {
        return problemeRepository.save(probleme);
    }

    @Override
    public Solution ajouter_Une_Solution(Solution solution) {
        return solutionRepository.save(solution);
    }

    @Override
    public Commentaire faire_un_Commentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    @Override
    public Compte creer(Compte compte) {
        return compteRepository.save(compte);
    }
}
