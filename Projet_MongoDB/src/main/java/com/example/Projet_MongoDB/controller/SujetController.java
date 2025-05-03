package com.example.Projet_MongoDB.controller;

import com.example.Projet_MongoDB.model.Sujet;
import com.example.Projet_MongoDB.service.SujetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sujets")
public class SujetController {

    private final SujetService sujetService;

    @Autowired
    public SujetController(SujetService sujetService) {
        this.sujetService = sujetService;
    }

    // Ajouter un sujet
    @PostMapping
    public Sujet addSujet(@RequestBody Sujet sujet) {
        return sujetService.addSujet(sujet);
    }

    // Récupérer tous les sujets
    @GetMapping
    public List<Sujet> getAllSujets() {
        return sujetService.getAllSujets();
    }

    // Récupérer un sujet par ID
    @GetMapping("/{id}")
    public Optional<Sujet> getSujetById(@PathVariable String id) {
        return sujetService.getSujetById(id);
    }

    // Supprimer un sujet
    @DeleteMapping("/{id}")
    public void deleteSujet(@PathVariable String id) {
        sujetService.deleteSujet(id);
    }

    // Rechercher un sujet par mot-clé dans le titre
    @GetMapping("/search/{titre}")
    public List<Sujet> searchSujetsByTitre(@PathVariable String titre) {
        return sujetService.searchSujetsByTitre(titre);
    }

    // Lister tous les sujets validés
    @GetMapping("/valides")
    public List<Sujet> getSujetsValides() {
        return sujetService.getSujetsValides();
    }

    // Lister tous les sujets non validés
    @GetMapping("/non-valides")
    public List<Sujet> getSujetsNonValides() {
        return sujetService.getSujetsNonValides();
    }
}
