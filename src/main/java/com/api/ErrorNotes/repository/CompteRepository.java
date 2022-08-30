package com.api.ErrorNotes.repository;

import com.api.ErrorNotes.modele.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {

    Compte findByEmail(String email);

}
