package com.example.Projet_MongoDB.repository;

import com.example.Projet_MongoDB.model.DocumentProjet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentProjetRepository extends MongoRepository<DocumentProjet, String> {

    // Trouver tous les documents par nom approximatif
    List<DocumentProjet> findByNomFichierContainingIgnoreCase(String nomFichier);
}

