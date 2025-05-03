package com.example.Projet_MongoDB.controller;

import com.example.Projet_MongoDB.model.Feedback;
import com.example.Projet_MongoDB.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    // Ajouter un feedback
    @PostMapping
    public Feedback addFeedback(@RequestBody Feedback feedback) {
        return feedbackService.addFeedback(feedback);
    }

    // Récupérer tous les feedbacks
    @GetMapping
    public List<Feedback> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }

    // Récupérer un feedback par ID
    @GetMapping("/{id}")
    public Optional<Feedback> getFeedbackById(@PathVariable String id) {
        return feedbackService.getFeedbackById(id);
    }

    // Supprimer un feedback
    @DeleteMapping("/{id}")
    public void deleteFeedback(@PathVariable String id) {
        feedbackService.deleteFeedback(id);
    }

    // Rechercher les feedbacks donnés par un encadrant
    @GetMapping("/auteur/{auteurId}")
    public List<Feedback> getFeedbacksByAuteurId(@PathVariable String auteurId) {
        return feedbackService.getFeedbacksByAuteurId(auteurId);
    }

    // Rechercher des feedbacks par mot-clé dans le commentaire
    @GetMapping("/search/{motCle}")
    public List<Feedback> searchFeedbacksByMotCle(@PathVariable String motCle) {
        return feedbackService.searchFeedbacksByMotCle(motCle);
    }
}
