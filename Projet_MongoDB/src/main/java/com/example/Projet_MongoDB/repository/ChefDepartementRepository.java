package com.example.Projet_MongoDB.repository;

import com.example.Projet_MongoDB.model.ChefDepartement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefDepartementRepository extends MongoRepository<ChefDepartement, String> {

    // Trouver un chef de département par son email
    ChefDepartement findByEmail(String email);
}

