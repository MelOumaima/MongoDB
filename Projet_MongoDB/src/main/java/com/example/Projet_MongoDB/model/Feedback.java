package com.example.Projet_MongoDB.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;


@Document(collection = "feedbacks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    @Id
    private String id;

    private String commentaire;  // Le contenu du feedback
    private Date date;            // Date où le feedback a été donné

    @DBRef
    private Encadrant auteur;     // L'encadrant qui a donné ce feedback
}
