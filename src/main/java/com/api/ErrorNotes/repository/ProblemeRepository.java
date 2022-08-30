package com.api.ErrorNotes.repository;

import com.api.ErrorNotes.modele.Probleme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProblemeRepository extends JpaRepository<Probleme, Long> {

    @Query(value = "SELECT Probleme.titre, Probleme.description, Probleme.date, Etat.nom_etat, Technologie.nom_techonologie FROM Probleme, Etat where id = id_etat",nativeQuery = true)
    public Iterable<Object[]> FIND_PROBLEME();
    Probleme findByTitre(String titre);

}
