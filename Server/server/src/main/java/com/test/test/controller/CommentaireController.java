package com.test.test.controller;

import com.test.test.model.Commentaire;
import com.test.test.model.Utilisateur;
import com.test.test.services.CommentaireService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class CommentaireController {

    private final CommentaireService commentaireService;

    public CommentaireController(CommentaireService commentaireService) {
        this.commentaireService = commentaireService;
    }

    @GetMapping("/commentaire/{id}")
    public List<Commentaire> findCommentaire(@PathVariable("id") Long id){
        return this.commentaireService.findAll(id);
    }

    @PostMapping("/commenter")
    public Commentaire save(@RequestBody Commentaire commentaire){
        return this.commentaireService.save(commentaire);
    }
}
