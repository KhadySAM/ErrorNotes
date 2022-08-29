package com.api.ErrorNotes.ServiceImpl;

import com.api.ErrorNotes.modele.Probleme;
import com.api.ErrorNotes.repository.ProblemeRepository;
import com.api.ErrorNotes.service.ProblemeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class ProblemeServiceimpl implements ProblemeService {
    private final ProblemeRepository problemeRepository;
    @Override
    public Probleme soumettre(Probleme probleme) {
        return null;
    }

    @Override
    public Probleme rechercher(Probleme probleme) {
        return null;
    }
}
