package com.example.Projet_MongoDB.repository;


import com.example.Projet_MongoDB.model.Projet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetRepository extends MongoRepository<Projet, String> {

    // Trouver tous les projets par leur statut (Ex: En cours, Terminé, Soutenu)
    List<Projet> findByStatut(String statut);

    // Trouver un projet par l'identifiant de l'étudiant
    Projet findByEtudiantId(String etudiantId);

    // Trouver un projet par l'identifiant du sujet
    Projet findBySujetId(String sujetId);
}
