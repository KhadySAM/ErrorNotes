package com.api.ErrorNotes.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProblemeAvoirTechnologie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_probtechno;

    @ManyToOne
    @JoinColumn(name = "id_prob")
    private Probleme probleme;

    @ManyToOne
    @JoinColumn(name = "id_tech")
    private Technologie technologie;

}
