package com.api.ErrorNotes.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TECHNOLOGIE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Technologie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_technologie;
    private String nom_techologie;

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
            joinColumns = @JoinColumn(name = "id_prob"),
            inverseJoinColumns = @JoinColumn(name = "id_tech")
    )
    private List<Technologie> technologies = new ArrayList<>();

}
