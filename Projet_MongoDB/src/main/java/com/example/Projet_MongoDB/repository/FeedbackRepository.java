package com.example.Projet_MongoDB.repository;

import com.example.Projet_MongoDB.model.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends MongoRepository<Feedback, String> {

    // Trouver tous les feedbacks donnés par un encadrant spécifique
    List<Feedback> findByAuteurId(String auteurId);

    // Chercher les feedbacks contenant un mot-clé dans le commentaire
    List<Feedback> findByCommentaireContainingIgnoreCase(String motCle);
}

