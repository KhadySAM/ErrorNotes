package com.api.ErrorNotes.repository;

import com.api.ErrorNotes.modele.Probleme;
import com.api.ErrorNotes.modele.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SolutionRepository extends JpaRepository<Solution, Long> {

    @Query(value = "select * from solution where id_pro = :id_pro", nativeQuery = true)
    public Solution FIND_SOLUTION_PAR_ID_PROBLEME(@Param("id_pro") Long id_pro);

    public Solution findByIds(Long ids);
    public  Solution findByProbleme(Probleme probleme);
}
