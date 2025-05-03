package com.example.Projet_MongoDB.controller;

import com.example.Projet_MongoDB.model.ChefDepartement;
import com.example.Projet_MongoDB.model.Sujet;
import com.example.Projet_MongoDB.service.ChefDepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chefs-departement")
public class ChefDepartementController {

    private final ChefDepartementService chefDepartementService;

    @Autowired
    public ChefDepartementController(ChefDepartementService chefDepartementService) {
        this.chefDepartementService = chefDepartementService;
    }

    // Ajouter un chef de département
    @PostMapping
    public ChefDepartement addChefDepartement(@RequestBody ChefDepartement chefDepartement) {
        return chefDepartementService.addChefDepartement(chefDepartement);
    }

    // Récupérer tous les chefs de département
    @GetMapping
    public List<ChefDepartement> getAllChefsDepartement() {
        return chefDepartementService.getAllChefsDepartement();
    }

    // Récupérer un chef de département par ID
    @GetMapping("/{id}")
    public Optional<ChefDepartement> getChefDepartementById(@PathVariable String id) {
        return chefDepartementService.getChefDepartementById(id);
    }

    // Supprimer un chef de département
    @DeleteMapping("/{id}")
    public void deleteChefDepartement(@PathVariable String id) {
        chefDepartementService.deleteChefDepartement(id);
    }

    // Chercher un chef de département par email
    @GetMapping("/email/{email}")
    public ChefDepartement getChefDepartementByEmail(@PathVariable String email) {
        return chefDepartementService.getChefDepartementByEmail(email);
    }

    // Valider un sujet
    @PostMapping("/valider-sujet")
    public Sujet validerSujet(@RequestBody Sujet sujet) {
        return chefDepartementService.validerSujet(sujet);
    }
}
