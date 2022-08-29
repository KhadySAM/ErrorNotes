package com.api.ErrorNotes.ServiceImpl;

import com.api.ErrorNotes.modele.Technologie;
import com.api.ErrorNotes.repository.TechnologieRepository;
import com.api.ErrorNotes.service.TechnologieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class TechnologieServiceimpl implements TechnologieService {
    private final TechnologieRepository technologieRepository;
    @Override
    public Technologie soumettre(Technologie technologie) {
        return null;
    }

    @Override
    public List<TechnologieService> lire() {
        return null;
    }
}
