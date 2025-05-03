package com.example.Projet_MongoDB.controller;

import com.example.Projet_MongoDB.model.Encadrant;
import com.example.Projet_MongoDB.model.Sujet;
import com.example.Projet_MongoDB.service.EncadrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/encadrants")
public class EncadrantController {

    private final EncadrantService encadrantService;

    @Autowired
    public EncadrantController(EncadrantService encadrantService) {
        this.encadrantService = encadrantService;
    }

    // Ajouter un encadrant
    @PostMapping
    public Encadrant addEncadrant(@RequestBody Encadrant encadrant) {
        return encadrantService.addEncadrant(encadrant);
    }

    // Récupérer tous les encadrants
    @GetMapping
    public List<Encadrant> getAllEncadrants() {
        return encadrantService.getAllEncadrants();
    }

    // Récupérer un encadrant par ID
    @GetMapping("/{id}")
    public Optional<Encadrant> getEncadrantById(@PathVariable String id) {
        return encadrantService.getEncadrantById(id);
    }

    // Supprimer un encadrant
    @DeleteMapping("/{id}")
    public void deleteEncadrant(@PathVariable String id) {
        encadrantService.deleteEncadrant(id);
    }

    // Chercher un encadrant par email
    @GetMapping("/email/{email}")
    public Encadrant getEncadrantByEmail(@PathVariable String email) {
        return encadrantService.getEncadrantByEmail(email);
    }

    // Récupérer les encadrants sans sujets proposés
    @GetMapping("/sans-sujet")
    public List<Encadrant> getEncadrantsSansSujets() {
        return encadrantService.getEncadrantsSansSujets();
    }

    // Proposer un sujet
    @PostMapping("/proposer-sujet")
    public Sujet proposerSujet(@RequestBody Sujet sujet) {
        return encadrantService.proposerSujet(sujet);
    }
}
