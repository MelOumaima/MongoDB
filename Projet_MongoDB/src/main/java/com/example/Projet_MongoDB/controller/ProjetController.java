package com.example.Projet_MongoDB.controller;

import com.example.Projet_MongoDB.model.Projet;
import com.example.Projet_MongoDB.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projets")
public class ProjetController {

    private final ProjetService projetService;

    @Autowired
    public ProjetController(ProjetService projetService) {
        this.projetService = projetService;
    }

    // Ajouter un projet
    @PostMapping
    public Projet addProjet(@RequestBody Projet projet) {
        return projetService.addProjet(projet);
    }

    // Récupérer tous les projets
    @GetMapping
    public List<Projet> getAllProjets() {
        return projetService.getAllProjets();
    }

    // Récupérer un projet par ID
    @GetMapping("/{id}")
    public Optional<Projet> getProjetById(@PathVariable String id) {
        return projetService.getProjetById(id);
    }

    // Supprimer un projet
    @DeleteMapping("/{id}")
    public void deleteProjet(@PathVariable String id) {
        projetService.deleteProjet(id);
    }

    // Récupérer les projets par statut
    @GetMapping("/statut/{statut}")
    public List<Projet> getProjetsByStatut(@PathVariable String statut) {
        return projetService.getProjetsByStatut(statut);
    }

    // Récupérer un projet par l'ID de l'étudiant
    @GetMapping("/etudiant/{etudiantId}")
    public Projet getProjetByEtudiantId(@PathVariable String etudiantId) {
        return projetService.getProjetByEtudiantId(etudiantId);
    }

    // Récupérer un projet par l'ID du sujet
    @GetMapping("/sujet/{sujetId}")
    public Projet getProjetBySujetId(@PathVariable String sujetId) {
        return projetService.getProjetBySujetId(sujetId);
    }
}
