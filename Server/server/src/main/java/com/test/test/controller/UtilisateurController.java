package com.test.test.controller;



import com.test.test.model.Utilisateur;
import com.test.test.services.UtilisateurService;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping("/login")
    public Utilisateur login(@RequestBody Utilisateur utilisateur){
        return this.utilisateurService.login(utilisateur.getNomUtilisateur(), utilisateur.getMdpUtilisateur());
    }

    @PostMapping("/saveUser")
    public Utilisateur saveUser(@RequestBody Utilisateur utilisateur){
        return this.utilisateurService.saveUser(utilisateur.getNomUtilisateur(), utilisateur.getMdpUtilisateur());
    }

}
