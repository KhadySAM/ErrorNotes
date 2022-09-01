package com.api.ErrorNotes.service.serviceImplementation;

import com.api.ErrorNotes.modele.Etat;
import com.api.ErrorNotes.modele.Technologie;
import com.api.ErrorNotes.repository.CommentaireRepository;
import com.api.ErrorNotes.repository.EtatRepository;
import com.api.ErrorNotes.repository.TechnologieRepository;
import com.api.ErrorNotes.modele.Compte;
import com.api.ErrorNotes.modele.Utilisateur;
import com.api.ErrorNotes.repository.CompteRepository;
import com.api.ErrorNotes.repository.UtilisateurRepository;

import com.api.ErrorNotes.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class AdminServiceImpl implements AdminService {


    private final EtatRepository etatRepository;
    private final TechnologieRepository technologieRepository;
    private final CommentaireRepository commentaireRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final CompteRepository compteRepository;

    @Override
    public Etat creerEtat(Etat etat, String email) {
        return etatRepository.save(etat);
    }

    @Override
    public Technologie creerTechnologie(Technologie technologie, String email) {
        return technologieRepository.save(technologie);
    }

    @Override
    public String supprimerCommentair(Long id) {
        commentaireRepository.deleteById(id);
        return "Commentaire Supprimer";
    }

    @Override
    public Utilisateur creerCompteAdmin(Utilisateur utilisateur, String email, String password) {
        //on instancie la classe compte
        Compte compte = new Compte();

        //on attribue au compte instacier l'email donné
        compte.setEmail(email);

        //on attribue également au compte instacier
        compte.setPassword(password);

        //on lui attribue le role admin
        compte.setRole("admin");

        //On associe le compte manupilé ci-dessus au l'utilisateur
        utilisateur.setCompte(compte);

        //on enregistre le compte de l'utilisateur
        compteRepository.save(compte);

        //on enregistre l'utilisateur lui-meme
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Etat TrouverEtatparNom(String nom) {

        return etatRepository.findByNom(nom);
    }

    /*@Override
    public List<Technologie> lireTechnologie() {
        return technologieRepository.findAll();
    }

    @Override
    public List<Etat> lireEtat() {
        return etatRepository.findAll();
    }*/

}

