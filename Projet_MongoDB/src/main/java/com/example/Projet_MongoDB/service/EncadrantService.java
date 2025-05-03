package com.example.Projet_MongoDB.service;

import com.example.Projet_MongoDB.model.Encadrant;
import com.example.Projet_MongoDB.model.Sujet;
import com.example.Projet_MongoDB.repository.EncadrantRepository;
import com.example.Projet_MongoDB.repository.SujetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncadrantService {

    private final EncadrantRepository encadrantRepository;
    private final SujetRepository sujetRepository;

    public EncadrantService(EncadrantRepository encadrantRepository, SujetRepository sujetRepository) {
        this.encadrantRepository = encadrantRepository;
        this.sujetRepository = sujetRepository;
    }

    // Ajouter un encadrant
    public Encadrant addEncadrant(Encadrant encadrant) {
        return encadrantRepository.save(encadrant);
    }

    // Récupérer tous les encadrants
    public List<Encadrant> getAllEncadrants() {
        return encadrantRepository.findAll();
    }

    // Récupérer un encadrant par ID
    public Optional<Encadrant> getEncadrantById(String id) {
        return encadrantRepository.findById(id);
    }

    // Supprimer un encadrant
    public void deleteEncadrant(String id) {
        encadrantRepository.deleteById(id);
    }

    // Récupérer un encadrant par email
    public Encadrant getEncadrantByEmail(String email) {
        return encadrantRepository.findByEmail(email);
    }

    // Lister tous les encadrants qui n'ont pas encore proposé de sujets
    public List<Encadrant> getEncadrantsSansSujets() {
        return encadrantRepository.findBySujetsProposesIsNull();
    }

    // Proposer un nouveau sujet
    public Sujet proposerSujet(Sujet sujet) {
        return sujetRepository.save(sujet);
    }
}
