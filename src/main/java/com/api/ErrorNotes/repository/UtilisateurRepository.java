package com.api.ErrorNotes.repository;

import com.api.ErrorNotes.modele.Compte;
import com.api.ErrorNotes.modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findByCompte(Compte compte);
//Essaiiiiiiiiiiiii
}
