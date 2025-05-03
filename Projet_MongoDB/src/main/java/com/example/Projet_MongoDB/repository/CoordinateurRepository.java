package com.example.Projet_MongoDB.repository;

import com.example.Projet_MongoDB.model.Coordinateur;
import com.example.Projet_MongoDB.model.Etudiant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoordinateurRepository extends MongoRepository<Coordinateur, String> {

    // Trouver un coordinateur par son email
    Coordinateur findByEmail(String email);
    //Optional<Coordinateur> findByEmail(String email);
}
