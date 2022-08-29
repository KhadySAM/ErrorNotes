package com.api.ErrorNotes.repository;

import com.api.ErrorNotes.modele.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
}
