package com.example.Projet_MongoDB.service;

import com.example.Projet_MongoDB.model.Sujet;
import com.example.Projet_MongoDB.repository.SujetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SujetService {

    private final SujetRepository sujetRepository;

    public SujetService(SujetRepository sujetRepository) {
        this.sujetRepository = sujetRepository;
    }

    // Ajouter un sujet
    public Sujet addSujet(Sujet sujet) {
        return sujetRepository.save(sujet);
    }

    // Récupérer tous les sujets
    public List<Sujet> getAllSujets() {
        return sujetRepository.findAll();
    }

    // Récupérer un sujet par ID
    public Optional<Sujet> getSujetById(String id) {
        return sujetRepository.findById(id);
    }

    // Supprimer un sujet
    public void deleteSujet(String id) {
        sujetRepository.deleteById(id);
    }

    // Rechercher des sujets par titre
    public List<Sujet> searchSujetsByTitre(String titre) {
        return sujetRepository.findByTitreContainingIgnoreCase(titre);
    }

    // Lister tous les sujets validés
    public List<Sujet> getSujetsValides() {
        return sujetRepository.findByEstValideTrue();
    }

    // Lister tous les sujets non validés
    public List<Sujet> getSujetsNonValides() {
        return sujetRepository.findByEstValideFalse();
    }
}
