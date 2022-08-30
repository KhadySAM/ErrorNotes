package com.api.ErrorNotes.modele;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "COMPTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String email;
    private String password;
    private String role;

    //private datedatefuj
}
