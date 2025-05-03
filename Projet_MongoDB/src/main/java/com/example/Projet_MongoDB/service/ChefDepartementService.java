package com.example.Projet_MongoDB.service;

import com.example.Projet_MongoDB.model.ChefDepartement;
import com.example.Projet_MongoDB.model.Sujet;
import com.example.Projet_MongoDB.repository.ChefDepartementRepository;
import com.example.Projet_MongoDB.repository.SujetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChefDepartementService {

    private final ChefDepartementRepository chefDepartementRepository;
    private final SujetRepository sujetRepository;

    public ChefDepartementService(ChefDepartementRepository chefDepartementRepository, SujetRepository sujetRepository) {
        this.chefDepartementRepository = chefDepartementRepository;
        this.sujetRepository = sujetRepository;
    }

    // Ajouter un chef de département
    public ChefDepartement addChefDepartement(ChefDepartement chefDepartement) {
        return chefDepartementRepository.save(chefDepartement);
    }

    // Récupérer tous les chefs de département
    public List<ChefDepartement> getAllChefsDepartement() {
        return chefDepartementRepository.findAll();
    }

    // Récupérer un chef de département par ID
    public Optional<ChefDepartement> getChefDepartementById(String id) {
        return chefDepartementRepository.findById(id);
    }

    // Supprimer un chef de département
    public void deleteChefDepartement(String id) {
        chefDepartementRepository.deleteById(id);
    }

    // Récupérer un chef de département par email
    public ChefDepartement getChefDepartementByEmail(String email) {
        return chefDepartementRepository.findByEmail(email);
    }

    // Valider un sujet
    public Sujet validerSujet(Sujet sujet) {
        sujet.setEstValide(true);
        return sujetRepository.save(sujet);
    }
}
