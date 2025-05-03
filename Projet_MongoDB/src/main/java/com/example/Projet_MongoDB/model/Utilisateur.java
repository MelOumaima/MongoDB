package com.example.Projet_MongoDB.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Utilisateur {

    @Id
    private String id;

    private String nom;
    private String email;
    private String motDePasse;
    private String role;
}
