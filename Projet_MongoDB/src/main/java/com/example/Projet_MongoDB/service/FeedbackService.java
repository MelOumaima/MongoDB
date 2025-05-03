package com.example.Projet_MongoDB.service;

import com.example.Projet_MongoDB.model.Feedback;
import com.example.Projet_MongoDB.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    // Ajouter un feedback
    public Feedback addFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    // Récupérer tous les feedbacks
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    // Récupérer un feedback par ID
    public Optional<Feedback> getFeedbackById(String id) {
        return feedbackRepository.findById(id);
    }

    // Supprimer un feedback
    public void deleteFeedback(String id) {
        feedbackRepository.deleteById(id);
    }

    // Chercher les feedbacks par auteur (encadrant)
    public List<Feedback> getFeedbacksByAuteurId(String auteurId) {
        return feedbackRepository.findByAuteurId(auteurId);
    }

    // Rechercher un feedback par mot-clé dans le commentaire
    public List<Feedback> searchFeedbacksByMotCle(String motCle) {
        return feedbackRepository.findByCommentaireContainingIgnoreCase(motCle);
    }
}
