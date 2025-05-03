package com.example.Projet_MongoDB.service;

import com.example.Projet_MongoDB.model.Coordinateur;
import com.example.Projet_MongoDB.model.Attestation;
import com.example.Projet_MongoDB.repository.CoordinateurRepository;
import com.example.Projet_MongoDB.repository.AttestationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoordinateurService {

    private final CoordinateurRepository coordinateurRepository;
    private final AttestationRepository attestationRepository;

    public CoordinateurService(CoordinateurRepository coordinateurRepository, AttestationRepository attestationRepository) {
        this.coordinateurRepository = coordinateurRepository;
        this.attestationRepository = attestationRepository;
    }

    // Ajouter un coordinateur
    public Coordinateur addCoordinateur(Coordinateur coordinateur) {
        return coordinateurRepository.save(coordinateur);
    }

    // Récupérer tous les coordinateurs
    public List<Coordinateur> getAllCoordinateurs() {
        return coordinateurRepository.findAll();
    }

    // Récupérer un coordinateur par ID
    public Optional<Coordinateur> getCoordinateurById(String id) {
        return coordinateurRepository.findById(id);
    }

    // Supprimer un coordinateur
    public void deleteCoordinateur(String id) {
        coordinateurRepository.deleteById(id);
    }

    // Récupérer un coordinateur par email
    public Coordinateur getCoordinateurByEmail(String email) {
        return coordinateurRepository.findByEmail(email);
    }

    // Signer une attestation
    public Attestation signerAttestation(Attestation attestation, Coordinateur coordinateur) {
        attestation.setEstSignee(true);
        attestation.setSignePar(coordinateur);
        attestation.setDateValidation(new java.util.Date());
        return attestationRepository.save(attestation);
    }
}
