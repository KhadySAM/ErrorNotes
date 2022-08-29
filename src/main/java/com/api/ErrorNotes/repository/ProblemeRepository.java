package com.api.ErrorNotes.repository;

import com.api.ErrorNotes.modele.Probleme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemeRepository extends JpaRepository<Probleme, Long> {
}
