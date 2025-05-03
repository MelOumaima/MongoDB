package com.example.Projet_MongoDB.repository;

import com.example.Projet_MongoDB.model.Utilisateur;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UtilisateurRepository extends MongoRepository<Utilisateur, String> {
    Optional<Utilisateur> findByEmail(String email);
}
