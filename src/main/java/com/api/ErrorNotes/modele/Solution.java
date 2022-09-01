package com.api.ErrorNotes.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SOLUTION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ids;
    private String contenu;
    private String methodologie;
    private Date date;

    @OneToOne
    @JoinColumn(name = "probleme_id")
    private Probleme probleme;

}
