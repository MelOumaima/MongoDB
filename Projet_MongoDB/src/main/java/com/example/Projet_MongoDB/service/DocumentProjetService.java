package com.example.Projet_MongoDB.service;

import com.example.Projet_MongoDB.model.DocumentProjet;
import com.example.Projet_MongoDB.repository.DocumentProjetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentProjetService {

    private final DocumentProjetRepository documentProjetRepository;

    public DocumentProjetService(DocumentProjetRepository documentProjetRepository) {
        this.documentProjetRepository = documentProjetRepository;
    }

    // Ajouter un document
    public DocumentProjet addDocument(DocumentProjet documentProjet) {
        return documentProjetRepository.save(documentProjet);
    }

    // Récupérer tous les documents
    public List<DocumentProjet> getAllDocuments() {
        return documentProjetRepository.findAll();
    }

    // Récupérer un document par ID
    public Optional<DocumentProjet> getDocumentById(String id) {

        return documentProjetRepository.findById(id);
    }

    // Supprimer un document
    public void deleteDocument(String id) {
        documentProjetRepository.deleteById(id);
    }

    // Rechercher des documents par nom
    public List<DocumentProjet> searchDocumentsByNom(String motCle) {
        return documentProjetRepository.findByNomFichierContainingIgnoreCase(motCle);
    }
}
