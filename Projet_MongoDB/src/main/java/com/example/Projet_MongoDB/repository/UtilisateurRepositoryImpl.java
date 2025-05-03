package com.example.Projet_MongoDB.repository;

import com.example.Projet_MongoDB.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UtilisateurRepositoryImpl implements UtilisateurRepositoryCustom {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private EncadrantRepository encadrantRepository;

    @Autowired
    private CoordinateurRepository coordinateurRepository;

    @Autowired
    private ChefDepartementRepository chefDepartementRepository;

    @Override
    public Optional<Utilisateur> findByEmail(String email) {
        // Chercher dans les étudiants
        Etudiant etu = etudiantRepository.findByEmail(email);
        if (etu != null) return Optional.of(etu);

        // Chercher dans les encadrants
        Encadrant enc = encadrantRepository.findByEmail(email);
        if (enc != null) return Optional.of(enc);

        // Chercher dans les coordinateurs
        Coordinateur coord = coordinateurRepository.findByEmail(email);
        if (coord != null) return Optional.of(coord);

        // Chercher dans les chefs de département
        ChefDepartement chef = chefDepartementRepository.findByEmail(email);
        if (chef != null) return Optional.of(chef);


        // Aucun utilisateur trouvé
        return Optional.empty();
    }
}
