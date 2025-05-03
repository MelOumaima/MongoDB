package com.example.Projet_MongoDB.service;

import com.example.Projet_MongoDB.model.Projet;
import com.example.Projet_MongoDB.repository.ProjetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetService {

    private final ProjetRepository projetRepository;

    public ProjetService(ProjetRepository projetRepository) {
        this.projetRepository = projetRepository;
    }

    // Ajouter un projet
    public Projet addProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    // Récupérer tous les projets
    public List<Projet> getAllProjets() {
        return projetRepository.findAll();
    }

    // Récupérer un projet par ID
    public Optional<Projet> getProjetById(String id) {
        return projetRepository.findById(id);
    }

    // Supprimer un projet
    public void deleteProjet(String id) {
        projetRepository.deleteById(id);
    }

    // Rechercher les projets par statut
    public List<Projet> getProjetsByStatut(String statut) {
        return projetRepository.findByStatut(statut);
    }

    // Trouver un projet par l'identifiant d'un étudiant
    public Projet getProjetByEtudiantId(String etudiantId) {
        return projetRepository.findByEtudiantId(etudiantId);
    }

    // Trouver un projet par l'identifiant d'un sujet
    public Projet getProjetBySujetId(String sujetId) {
        return projetRepository.findBySujetId(sujetId);
    }
}
