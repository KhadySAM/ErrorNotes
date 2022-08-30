package com.api.ErrorNotes.modele;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "UTILISATEUR")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nom;
    private String prenom;
    private String contact;

    //(cascade = CascadeType.ALL)
    @OneToOne
    private Compte compte;

}
