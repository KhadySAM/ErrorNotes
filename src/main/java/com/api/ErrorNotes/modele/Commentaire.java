package com.api.ErrorNotes.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "COMMENTAIRE")
@Getter
@Setter
@NoArgsConstructor
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_commentaire;
    private String cont_commentaire;
    private Date date_commentaire;

    @ManyToOne
    @JoinColumn(name = "id_sol")
    private Solution solution;

    @ManyToOne
    @JoinColumn(name = "Use")
    private Utilisateur utilisateur;
}
