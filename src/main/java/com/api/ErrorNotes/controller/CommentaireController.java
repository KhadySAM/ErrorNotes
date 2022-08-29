package com.api.ErrorNotes.controller;

import com.api.ErrorNotes.modele.Commentaire;
import com.api.ErrorNotes.service.CommentaireService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentaire")
@AllArgsConstructor

    public class CommentaireController {

    private final CommentaireService commentaireService;

    @PostMapping("/ajouter")
    public Commentaire ajouter(@RequestBody Commentaire commentaire) {
        return commentaireService.ajouter();
    }
        @GetMapping
        public List<Commentaire> lire(){
        return commentaireService.lire();

    }





}
