package com.example.Projet_MongoDB.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Document(collection = "encadrants")
@Data
//@NoArgsConstructor
@AllArgsConstructor
public class Encadrant extends Utilisateur {


    public Encadrant() {
        this.setRole("ENCADRANT");
    }

    @DBRef
    private List<Etudiant> etudiantsEncadres; // Liste des étudiants encadrés

    @DBRef
    private List<Sujet> sujetsProposes; // Sujets proposés par l'encadrant
}
