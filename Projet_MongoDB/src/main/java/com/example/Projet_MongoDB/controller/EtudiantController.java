package com.example.Projet_MongoDB.controller;

import com.example.Projet_MongoDB.model.Etudiant;
import com.example.Projet_MongoDB.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    private final EtudiantService etudiantService;

    @Autowired
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    // Ajouter un étudiant
    @PostMapping
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.addEtudiant(etudiant);
    }

    // Récupérer tous les étudiants
    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    // Récupérer un étudiant par ID
    @GetMapping("/{id}")
    public Optional<Etudiant> getEtudiantById(@PathVariable String id) {
        return etudiantService.getEtudiantById(id);
    }

    // Supprimer un étudiant par ID
    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable String id) {
        etudiantService.deleteEtudiant(id);
    }

    // Chercher un étudiant par email
    @GetMapping("/email/{email}")
    public Etudiant getEtudiantByEmail(@PathVariable String email) {
        return etudiantService.getEtudiantByEmail(email);
    }

    // Chercher un étudiant par CNE
    @GetMapping("/cne/{cne}")
    public Etudiant getEtudiantByCne(@PathVariable String cne) {
        return etudiantService.getEtudiantByCne(cne);
    }

    // Récupérer tous les étudiants sans projet
    @GetMapping("/sans-projet")
    public List<Etudiant> getEtudiantsSansProjet() {
        return etudiantService.getEtudiantsSansProjet();
    }
}
