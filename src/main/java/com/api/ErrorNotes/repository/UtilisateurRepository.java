package com.api.ErrorNotes.repository;

import com.api.ErrorNotes.modele.Compte;
import com.api.ErrorNotes.modele.Probleme;
import com.api.ErrorNotes.modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {


    Utilisateur findByCompte(Compte compte);
//Essaiiiiiiiiiiiii
}
