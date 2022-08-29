package com.api.ErrorNotes.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "RESSOURCE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ressource {

    @Id
    @GeneratedValue
    private Long id_ressource;
    private String liens;

    @ManyToOne
    @JoinColumn(name = "id_solut")
    private Solution solution;
}
