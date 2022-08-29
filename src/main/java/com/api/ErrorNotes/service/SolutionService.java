package com.api.ErrorNotes.service;

import com.api.ErrorNotes.modele.Solution;

import java.util.List;

public interface SolutionService {
    Solution soumettre(Solution solution);
    List<Solution> lire();
}
