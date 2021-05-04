package com.test.test.controller;

import com.test.test.model.Voiture;
import com.test.test.services.VoitureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class VoitureController {
    private final VoitureService voitureService;

    public VoitureController(VoitureService voitureService){
        this.voitureService = voitureService;
    }

    @GetMapping("/voitures")
    public List<Voiture> getAllVoiture(){
        return this.voitureService.findAll();
    }

    @GetMapping("/voiture/{id}")
    public Optional<Voiture> getVoitureById(@PathVariable("id") Long id){
        return this.voitureService.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Voiture> addVoiture(@RequestBody Voiture voiture){
        Voiture newVoiture = this.voitureService.addVoiture(voiture);
        return new ResponseEntity<>(newVoiture, HttpStatus.CREATED);
    }
}
