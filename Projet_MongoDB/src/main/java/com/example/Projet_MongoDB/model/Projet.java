package com.example.Projet_MongoDB.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;


@Document(collection = "projets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Projet {

    @Id
    private String id;

    @DBRef
    private Sujet sujet; // Le sujet sur lequel est basé le projet

    @DBRef
    private Etudiant etudiant; // L'étudiant qui réalise le projet

    private String statut; // Exemple : "En cours", "Validé", "Terminé"

    @DBRef
    private List<DocumentProjet> livrables; // Documents déposés

    @DBRef
    private List<Feedback> feedbacks; // Feedbacks donnés par les encadrants
}
