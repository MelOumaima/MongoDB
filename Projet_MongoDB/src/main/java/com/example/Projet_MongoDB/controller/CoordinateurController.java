package com.example.Projet_MongoDB.controller;

import com.example.Projet_MongoDB.model.Attestation;
import com.example.Projet_MongoDB.model.Coordinateur;
import com.example.Projet_MongoDB.service.CoordinateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coordinateurs")
public class CoordinateurController {

    private final CoordinateurService coordinateurService;

    @Autowired
    public CoordinateurController(CoordinateurService coordinateurService) {
        this.coordinateurService = coordinateurService;
    }

    // Ajouter un coordinateur
    @PostMapping
    public Coordinateur addCoordinateur(@RequestBody Coordinateur coordinateur) {
        return coordinateurService.addCoordinateur(coordinateur);
    }

    // Récupérer tous les coordinateurs
    @GetMapping
    public List<Coordinateur> getAllCoordinateurs() {
        return coordinateurService.getAllCoordinateurs();
    }

    // Récupérer un coordinateur par ID
    @GetMapping("/{id}")
    public Optional<Coordinateur> getCoordinateurById(@PathVariable String id) {
        return coordinateurService.getCoordinateurById(id);
    }

    // Supprimer un coordinateur
    @DeleteMapping("/{id}")
    public void deleteCoordinateur(@PathVariable String id) {
        coordinateurService.deleteCoordinateur(id);
    }

    // Chercher un coordinateur par email
    @GetMapping("/email/{email}")
    public Coordinateur getCoordinateurByEmail(@PathVariable String email) {
        return coordinateurService.getCoordinateurByEmail(email);
    }


    // Signer une attestation
    @PostMapping("/signer-attestation")
    public Attestation signerAttestation(@RequestBody Attestation attestation, @RequestParam String coordinateurId) {
        Coordinateur coordinateur = coordinateurService.getCoordinateurById(coordinateurId)
                .orElseThrow(() -> new RuntimeException("Coordinateur non trouvé"));
        return coordinateurService.signerAttestation(attestation, coordinateur);
    }
}
