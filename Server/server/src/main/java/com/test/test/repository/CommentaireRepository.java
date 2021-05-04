package com.test.test.repository;

import com.test.test.model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentaireRepository extends JpaRepository<Commentaire,Long> {

    List<Commentaire> findCommentaireByIdVoiture(Long idVoiture);

}
