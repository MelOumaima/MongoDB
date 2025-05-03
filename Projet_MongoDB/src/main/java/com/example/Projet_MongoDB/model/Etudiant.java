package com.example.Projet_MongoDB.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Document(collection = "etudiants")
@Data
//@NoArgsConstructor
@AllArgsConstructor
public class Etudiant extends Utilisateur {

    public Etudiant() {
        this.setRole("ETUDIANT");
    }

    private String cne; // Code national étudiant

    @DBRef
    private Projet projet; // Lien vers son projet (1 étudiant => 1 projet)

    @DBRef
    private List<DocumentProjet> documents; // Les documents déposés (0..*)

    @DBRef
    private Attestation attestation; // Attestation de stage signée
}