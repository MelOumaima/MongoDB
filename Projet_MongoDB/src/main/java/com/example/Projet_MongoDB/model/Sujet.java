package com.example.Projet_MongoDB.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;


@Document(collection = "sujets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sujet {

    @Id
    private String id;

    private String titre;
    private String description;
    private boolean estValide; // Validé par le chef de département ou coordinateur

    @DBRef
    private Encadrant proposePar; // L'encadrant qui propose ce sujet
}
