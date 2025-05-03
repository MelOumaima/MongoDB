package com.example.Projet_MongoDB.controller;


import com.example.Projet_MongoDB.model.Attestation;
import com.example.Projet_MongoDB.model.Coordinateur;
import com.example.Projet_MongoDB.service.AttestationService;
import com.example.Projet_MongoDB.service.CoordinateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attestations")
public class AttestationController {

    private final AttestationService attestationService;
    private final CoordinateurService coordinateurService;

    @Autowired
    public AttestationController(AttestationService attestationService, CoordinateurService coordinateurService) {
        this.attestationService = attestationService;
        this.coordinateurService = coordinateurService;
    }

    // Ajouter une attestation
    @PostMapping
    public Attestation addAttestation(@RequestBody Attestation attestation) {
        return attestationService.addAttestation(attestation);
    }

    // Récupérer toutes les attestations
    @GetMapping
    public List<Attestation> getAllAttestations() {
        return attestationService.getAllAttestations();
    }

    // Récupérer une attestation par ID
    @GetMapping("/{id}")
    public Optional<Attestation> getAttestationById(@PathVariable String id) {
        return attestationService.getAttestationById(id);
    }

    // Supprimer une attestation
    @DeleteMapping("/{id}")
    public void deleteAttestation(@PathVariable String id) {
        attestationService.deleteAttestation(id);
    }

    // Valider (signer) une attestation
    @PostMapping("/valider")
    public Attestation validerAttestation(@RequestBody Attestation attestation, @RequestParam String coordinateurId) {
        Coordinateur coordinateur = coordinateurService.getCoordinateurById(coordinateurId)
                .orElseThrow(() -> new RuntimeException("Coordinateur non trouvé"));
        return attestationService.validerAttestation(attestation, coordinateur);
    }

    // Lister toutes les attestations validées
    @GetMapping("/validees")
    public List<Attestation> getAttestationsValidees() {
        return attestationService.getAttestationsValidees();
    }

    // Lister toutes les attestations non validées
    @GetMapping("/non-validees")
    public List<Attestation> getAttestationsNonValidees() {
        return attestationService.getAttestationsNonValidees();
    }

    // Lister toutes les attestations signées par un coordinateur donné
    @GetMapping("/coordinateur/{coordinateurId}")
    public List<Attestation> getAttestationsByCoordinateurId(@PathVariable String coordinateurId) {
        return attestationService.getAttestationsByCoordinateurId(coordinateurId);
    }
}
