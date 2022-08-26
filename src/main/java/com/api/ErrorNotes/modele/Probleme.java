package com.api.ErrorNotes.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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
    private Date date;
}
