package com.api.ErrorNotes.service.serviceImplementation;

import com.api.ErrorNotes.modele.*;
import com.api.ErrorNotes.repository.*;
import com.api.ErrorNotes.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {

    private final ProblemeRepository problemeRepository;
    private final CommentaireRepository commentaireRepository;
    private final SolutionRepository solutionRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final CompteRepository compteRepository;
    private final TechnologieRepository technologieRepository;
    private final ProblemeAvoirTechnologieRepository problemeAvoirTechnologieRepository;
    private final RessourceRepository ressourceRepository;

    @Override
    public Probleme creerProbleme(Probleme probleme, Utilisateur user) {
        //definition de l'etat
        Etat etat = new Etat();

        //on met l'etat à létat initial
        etat.setId(1L);


        //on attribue cet etat au problème
        probleme.setEtat(etat);

        //On attribue user recuperer en parametre au problème
        probleme.setUtilisateur(user);

        //on attribue la date actuelle au problème
        probleme.setDate(new Date());

        //On enregistre le problème
        return problemeRepository.save(probleme);
    }

    @Override
    public Solution creerSolution(Solution solution, Probleme probleme) {
        //instaciation du probleme
        Probleme prob = new Probleme();

        //Instaciation de l'etat
        Etat etat = new Etat();

        //Attribution de l'id 2(fermé) à l'etat
        etat.setId(2L);

        //On met le probleme à l'état fermé
        probleme.setEtat(etat);

        //definition du probleme conserné de la solution
        solution.setProbleme(probleme);

        return solutionRepository.save(solution);
    }

    @Override
    public Commentaire creerCommentaire(Commentaire commentaire, Utilisateur utilisateur, Solution solution) {

        //attribution de de la date actuelle au commentaire
        commentaire.setDate_commentaire(new Date());

        //attribution de l'user au commentaire
        commentaire.setUtilisateur(utilisateur);

        //attribution de la solution au probleme
        commentaire.setSolution(solution);

        //enregistrement du commentaire
        return commentaireRepository.save(commentaire);
    }

    //fonction utilisé pour verfier si l'user a un compte pas et si son password est correct
    @Override
    public Boolean connexion(String email, String password) {

        ///on se sert de l'email de l'user pour recuperer son compte
        Compte compte = compteRepository.findByEmail(email);

        //on verfie si son compte a été retrouvé ou pas, et si son password est correct également
        if(compte != null && compte.getPassword().equals(password)){
            System.out.println("Connexion éffectuée avec succes");
            return true;
        }else {//lorsque son compte n'a pas été retrouvé
            System.out.println("ce compte n'existe pas");
            return false;
        }
    }

    @Override
    public Probleme trouverProblemeParTitre(String titre) {

        return problemeRepository.findByTitre(titre);
    }

    @Override
    public Solution trouverSolutionParIdProbleme(Long problemeId) {

        return solutionRepository.FIND_SOLUTION_PAR_ID_PROBLEME(problemeId);
    }

    @Override
    public Compte trouverCompteParEmail(String email) {

        return compteRepository.findByEmail(email);
    }

    @Override
    public Probleme trouverProblemeParId(Long id) {

        return  problemeRepository.findById(id).get();
    }

    @Override
    public Utilisateur trouverUtilisateurParCompte(Compte compte) {

        return utilisateurRepository.findByCompte(compte);
    }

    @Override
    public List<ProblemeAvoirTechnologie> enregistrerProblemesTechnologies(List<ProblemeAvoirTechnologie> protechnologie) {
        return problemeAvoirTechnologieRepository.saveAll(protechnologie);
    }

    @Override
    public Technologie trouverTechonologieParNom(String nom) {

        return technologieRepository.findByNom(nom);
    }

    @Override
    public List<Ressource> enregistrerRessource(List<Ressource> ressources) {
        return ressourceRepository.saveAll(ressources);
    }


}
