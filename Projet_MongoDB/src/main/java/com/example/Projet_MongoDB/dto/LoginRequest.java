package com.example.Projet_MongoDB.dto;


import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String motDePasse;

    // Getters & Setters
}
