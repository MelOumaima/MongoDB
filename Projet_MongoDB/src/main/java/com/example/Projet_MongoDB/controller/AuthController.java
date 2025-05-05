package com.example.Projet_MongoDB.controller;

import com.example.Projet_MongoDB.dto.LoginRequest;
import com.example.Projet_MongoDB.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return utilisateurRepository.findByEmail(request.getEmail())
                .map(utilisateur -> {
                    if (utilisateur.getMotDePasse().equals(request.getMotDePasse())) {
                        return ResponseEntity.ok(utilisateur);
                    } else {
                        return ResponseEntity.status(401).body("Mot de passe incorrect");
                    }
                })
                .orElse(ResponseEntity.status(404).body("Utilisateur non trouvé"));
    }
}
