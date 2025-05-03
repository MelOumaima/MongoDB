package com.example.Projet_MongoDB.service;

import com.example.Projet_MongoDB.model.Attestation;
import com.example.Projet_MongoDB.model.Coordinateur;
import com.example.Projet_MongoDB.repository.AttestationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttestationService {

    private final AttestationRepository attestationRepository;

    public AttestationService(AttestationRepository attestationRepository) {
        this.attestationRepository = attestationRepository;
    }

    // Ajouter une attestation (avant validation)
    public Attestation addAttestation(Attestation attestation) {
        return attestationRepository.save(attestation);
    }

    // Récupérer toutes les attestations
    public List<Attestation> getAllAttestations() {
        return attestationRepository.findAll();
    }

    // Récupérer une attestation par ID
    public Optional<Attestation> getAttestationById(String id) {
        return attestationRepository.findById(id);
    }

    // Supprimer une attestation
    public void deleteAttestation(String id) {
        attestationRepository.deleteById(id);
    }

    // Valider (signer) une attestation
    public Attestation validerAttestation(Attestation attestation, Coordinateur coordinateur) {
        attestation.setEstSignee(true);
        attestation.setSignePar(coordinateur);
        attestation.setDateValidation(new java.util.Date());
        return attestationRepository.save(attestation);
    }

    // Récupérer les attestations validées
    public List<Attestation> getAttestationsValidees() {
        return attestationRepository.findByEstSigneeTrue();
    }

    // Récupérer les attestations non encore validées
    public List<Attestation> getAttestationsNonValidees() {
        return attestationRepository.findByEstSigneeFalse();
    }

    // Récupérer les attestations signées par un coordinateur spécifique
    public List<Attestation> getAttestationsByCoordinateurId(String coordinateurId) {
        return attestationRepository.findBySigneParId(coordinateurId);
    }
}