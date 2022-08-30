package com.api.ErrorNotes.repository;

import com.api.ErrorNotes.modele.Etat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtatRepository extends JpaRepository<Etat, Long> {

    Etat findByNom(String nom);
}
