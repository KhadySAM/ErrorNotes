package com.api.ErrorNotes.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PROBLEME")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Probleme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_probleme;
    private String titre;
    private String description;
    private Date date_probleme;

    @ManyToOne
    @JoinColumn(name = "id_Use")
    private Utilisateur utilisateur;


    @ManyToOne
    @JoinColumn(name = "id_Eta")
    private Etat etat;

    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
//definition de la relation entre les deux tables Jointable pour lier les deux colone dans chaque table
    @JoinTable(
            name = "ProblemeAvoirTechnologie",
            joinColumns = @JoinColumn(name = "id_tech"),
            inverseJoinColumns = @JoinColumn(name = "id_prob")
    )
    private List<Technologie> technologies = new ArrayList<>();

}
