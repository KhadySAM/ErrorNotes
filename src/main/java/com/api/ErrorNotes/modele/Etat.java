package com.api.ErrorNotes.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ETAT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_etat;
    private String nom_etat;
}
