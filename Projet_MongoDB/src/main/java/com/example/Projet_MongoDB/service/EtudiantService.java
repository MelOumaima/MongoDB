package com.example.Projet_MongoDB.service;

import com.example.Projet_MongoDB.model.Etudiant;
import com.example.Projet_MongoDB.repository.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    // Ajouter un étudiant
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    // Récupérer tous les étudiants
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    // Récupérer un étudiant par ID
    public Optional<Etudiant> getEtudiantById(String id) {
        return etudiantRepository.findById(id);
    }

    // Supprimer un étudiant
    public void deleteEtudiant(String id) {
        etudiantRepository.deleteById(id);
    }

    // Récupérer un étudiant par email
    public Etudiant getEtudiantByEmail(String email) {
        return etudiantRepository.findByEmail(email);
    }

    // Récupérer un étudiant par CNE
    public Etudiant getEtudiantByCne(String cne) {
        return etudiantRepository.findByCne(cne);
    }

    // Trouver les étudiants sans projet
    public List<Etudiant> getEtudiantsSansProjet() {
        return etudiantRepository.findByProjetIsNull();
    }
}
