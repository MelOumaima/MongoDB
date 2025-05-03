package com.example.Projet_MongoDB.repository;

import com.example.Projet_MongoDB.model.Coordinateur;
import com.example.Projet_MongoDB.model.Encadrant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EncadrantRepository extends MongoRepository<Encadrant, String> {

    // Trouver un encadrant par son email
    Encadrant findByEmail(String email);
    //Optional<Encadrant> findByEmail(String email);

    // Chercher les encadrants par leur nom
    List<Encadrant> findByNomContainingIgnoreCase(String nom);

    // Trouver tous les encadrants qui n'ont proposé aucun sujet
    List<Encadrant> findBySujetsProposesIsNull();
}
