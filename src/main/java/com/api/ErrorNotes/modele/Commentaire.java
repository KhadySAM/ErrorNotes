package com.api.ErrorNotes.modele;

import lombok.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "COMMENTAIRE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cont_commentaire;
    private Date date_commentaire;

    @ManyToOne
    @JoinColumn(name = "solution_id")
    private Solution solution;
    @ManyToOne
    @JoinColumn(name = "utilisateur")

    private Utilisateur utilisateur;
}
