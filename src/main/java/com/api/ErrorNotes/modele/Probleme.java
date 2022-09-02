package com.api.ErrorNotes.modele;
import lombok.*;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Probleme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String titre;
    private String description;
    private Date date;


    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;




    @ManyToOne
    @JoinColumn(name = "etat_id")
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
            joinColumns = @JoinColumn(name = "techno_id"),
            inverseJoinColumns = @JoinColumn(name = "probleme_id")
    )
    private List<Technologie> technologies = new ArrayList<>();

}
