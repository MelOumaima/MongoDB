package com.example.Projet_MongoDB.repository;


import com.example.Projet_MongoDB.model.Sujet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SujetRepository extends MongoRepository<Sujet, String> {

    // Trouver les sujets par titre partiel (recherche approximative)
    List<Sujet> findByTitreContainingIgnoreCase(String titre);

    // Trouver tous les sujets validés
    List<Sujet> findByEstValideTrue();

    // Trouver tous les sujets en attente de validation
    List<Sujet> findByEstValideFalse();
}

