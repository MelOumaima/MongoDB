package com.example.Projet_MongoDB.controller;

import com.example.Projet_MongoDB.model.DocumentProjet;
import com.example.Projet_MongoDB.service.DocumentProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/documents")
public class DocumentProjetController {

    private final DocumentProjetService documentProjetService;

    @Autowired
    public DocumentProjetController(DocumentProjetService documentProjetService) {
        this.documentProjetService = documentProjetService;
    }

    // Ajouter un document
    @PostMapping
    public DocumentProjet addDocument(@RequestBody DocumentProjet documentProjet) {
        return documentProjetService.addDocument(documentProjet);
    }

    // Récupérer tous les documents
    @GetMapping
    public List<DocumentProjet> getAllDocuments() {
        return documentProjetService.getAllDocuments();
    }

    // Récupérer un document par ID
    @GetMapping("/{id}")
    public Optional<DocumentProjet> getDocumentById(@PathVariable String id) {
        return documentProjetService.getDocumentById(id);
    }

    // Supprimer un document
    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable String id) {
        documentProjetService.deleteDocument(id);
    }

    // Rechercher des documents par mot-clé dans le nom
    @GetMapping("/search/{motCle}")
    public List<DocumentProjet> searchDocumentsByNom(@PathVariable String motCle) {
        return documentProjetService.searchDocumentsByNom(motCle);
    }
}
