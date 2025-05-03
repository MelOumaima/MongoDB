package com.example.Projet_MongoDB.repository;

import com.example.Projet_MongoDB.model.Etudiant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EtudiantRepository extends MongoRepository<Etudiant, String> {

    // Trouver un étudiant par son email
    Etudiant findByEmail(String email);
    //Optional<Etudiant> findByEmail(String email);

    // Trouver un étudiant par son CNE
    Etudiant findByCne(String cne);

    // Chercher les étudiants par leur nom
    List<Etudiant> findByNomContainingIgnoreCase(String nom);

    // Trouver les étudiants qui n'ont pas encore de projet
    List<Etudiant> findByProjetIsNull();
}
