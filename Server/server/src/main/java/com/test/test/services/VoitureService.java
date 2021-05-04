package com.test.test.services;

import com.test.test.model.Voiture;
import com.test.test.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoitureService {
    private final VoitureRepository voitureRepository;

    @Autowired
    public VoitureService(VoitureRepository voitureRepository){
        this.voitureRepository = voitureRepository;
    }

    public Voiture addVoiture(Voiture voiture){
        return this.voitureRepository.save(voiture);
    }

    public List<Voiture> findAll(){
        return this.voitureRepository.findAll();
    }

    public Optional<Voiture> findById(Long idVoiture){
        return this.voitureRepository.findById(idVoiture);
    }
}
