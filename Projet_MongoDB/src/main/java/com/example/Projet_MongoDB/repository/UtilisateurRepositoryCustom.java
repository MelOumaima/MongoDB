package com.example.Projet_MongoDB.repository;

import com.example.Projet_MongoDB.model.Utilisateur;
import java.util.Optional;

public interface UtilisateurRepositoryCustom {
    Optional<Utilisateur> findByEmail(String email);
}
