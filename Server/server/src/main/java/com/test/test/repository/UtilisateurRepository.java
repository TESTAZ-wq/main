package com.test.test.repository;

import com.test.test.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Utilisateur findUtilisateurByNomUtilisateurAndMdpUtilisateur(String nomUtilisateur, String mdpUtilisateur);
}
