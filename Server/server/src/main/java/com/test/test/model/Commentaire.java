package com.test.test.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Entity
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCommentaire;
    private Long idVoiture;
    private String commentaire;
    private Date dateCommentaire;
    private Long idUtilisateur;


    private String utilisateur;

    public Commentaire() {
    }

    public Commentaire(Long idCommentaire, Long idVoiture, String commentaire, Date dateCommentaire, Long idUtilisateur) {
        this.idCommentaire = idCommentaire;
        this.idVoiture = idVoiture;
        this.commentaire = commentaire;
        this.dateCommentaire = dateCommentaire;
        this.idUtilisateur = idUtilisateur;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Long getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(Long idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public Long getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(Long idVoiture) {
        this.idVoiture = idVoiture;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Date getDateCommentaire() {
        return dateCommentaire;
    }

    public void setDateCommentaire(Date dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }

}
