package com.api.ErrorNotes.ServiceImpl;

import com.api.ErrorNotes.modele.Solution;
import com.api.ErrorNotes.repository.SolutionRepository;
import com.api.ErrorNotes.service.SolutionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class SolutionServiceimpl implements SolutionService {
    private final SolutionRepository solutionRepository;
    @Override
    public Solution soumettre(Solution solution) {
        return null;
    }

    @Override
    public List<Solution> lire() {
        return null;
    }
}
