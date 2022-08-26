package com.api.ErrorNotes.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
}
