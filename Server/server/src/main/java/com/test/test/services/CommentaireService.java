package com.test.test.services;

import com.test.test.model.Commentaire;
import com.test.test.model.Utilisateur;
import com.test.test.repository.CommentaireRepository;
import com.test.test.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentaireService {

    private final CommentaireRepository commentaireRepository;
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public CommentaireService(CommentaireRepository commentaireRepository,UtilisateurRepository utilisateurRepository) {
        this.commentaireRepository = commentaireRepository;
        this.utilisateurRepository = utilisateurRepository;
    }


    public List<Commentaire> findAll(Long idVoiture){
        List<Commentaire> commentaires = new ArrayList<>();
        commentaires = this.commentaireRepository.findCommentaireByIdVoiture(idVoiture);
        String name = "";
        for (int i=0;i<commentaires.size();i++){
            name = utilisateurRepository.findById(commentaires.get(i).getIdUtilisateur()).get().getNomUtilisateur();
            commentaires.get(i).setUtilisateur(name);
        }
        return commentaires;
    }

    public Commentaire save(Commentaire commentaire){
        return this.commentaireRepository.save(commentaire);
    }
}
