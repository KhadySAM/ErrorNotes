package com.api.ErrorNotes.modele;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class ProblemeAvoirTechnologie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "probleme_id")
    private Probleme probleme;

    @ManyToOne
    @JoinColumn(name = "techno_id")
    private Technologie technologie;

}
