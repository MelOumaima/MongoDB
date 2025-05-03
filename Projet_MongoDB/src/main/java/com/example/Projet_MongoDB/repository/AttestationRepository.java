package com.example.Projet_MongoDB.repository;

import com.example.Projet_MongoDB.model.Attestation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttestationRepository extends MongoRepository<Attestation, String> {

    // Trouver toutes les attestations signées
    List<Attestation> findByEstSigneeTrue();

    // Trouver toutes les attestations non encore signées
    List<Attestation> findByEstSigneeFalse();

    // Chercher les attestations validées par un coordinateur spécifique
    List<Attestation> findBySigneParId(String coordinateurId);
}

