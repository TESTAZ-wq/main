package com.test.test.services;


import com.test.test.model.Utilisateur;
import com.test.test.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository = utilisateurRepository;
    }

    public Utilisateur addVoiture(Utilisateur utilisateur){
        return this.utilisateurRepository.save(utilisateur);
    }

    public List<Utilisateur> findAll(){
        return this.utilisateurRepository.findAll();
    }

    public Utilisateur login(String nomUtilisateur,String mdpUtilisateur) {
       return this.utilisateurRepository.findUtilisateurByNomUtilisateurAndMdpUtilisateur(nomUtilisateur,mdpUtilisateur);
    }

    public Utilisateur saveUser(String nomUtilisateur,String mdpUtilisateur) {
        return this.utilisateurRepository.save(new Utilisateur(nomUtilisateur,mdpUtilisateur));
    }
}
