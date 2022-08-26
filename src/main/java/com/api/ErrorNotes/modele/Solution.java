package com.api.ErrorNotes.modele;

import javax.persistence.*;

@Entity
@Table(name = "SOLUTION")
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_solution;
    private String description;
    private String methodologie;
    private String temps_resolution;
}
