package com.api.ErrorNotes.service.serviceImplementation;

import com.api.ErrorNotes.modele.*;
import com.api.ErrorNotes.repository.*;
import com.api.ErrorNotes.service.UserVisitorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserVisitorServiceImpl implements UserVisitorService {
    final ProblemeRepository problemeRepository;
    final CommentaireRepository commentaireRepository;
    final SolutionRepository solutionRepository;
    final UtilisateurRepository utilisateurRepository;
    final CompteRepository compteRepository;
    final TechnologieRepository technologieRepository;


    //Implementation de la methode permettant de créer un compte utilisateur
/*    @Autowired
    private PasswordEncoder passwordEncoder;*/
    @Override
    public Utilisateur creerCompteUser(Utilisateur utilisateur, String email, String password) {
        Compte compte = new Compte();
        compte.setEmail(email);
        compte.setPassword(password);
      /*  //recuperation du mot de passe
        String pass = compte.getPassword();
        compte.setPassword(passwordEncoder.encode(pass));*/
        compte.setRole("user");
        compteRepository.save(compte);
        utilisateur.setCompte(compte);
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public List<Probleme> lireProbleme() {

        return problemeRepository.findAll();
    }


    @Override
    public List<Commentaire> lireCommentaire() {

        return commentaireRepository.findAll();
    }

    @Override
    public List<Solution> lireSolution() {

        return solutionRepository.findAll();
    }


}
