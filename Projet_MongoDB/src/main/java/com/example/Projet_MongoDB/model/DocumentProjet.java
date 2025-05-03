package com.example.Projet_MongoDB.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.Date;


@Document(collection = "documents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentProjet {

    @Id
    private String id;

    private String nomFichier;    // Le nom du fichier
    private Date dateDepot;       // La date de dépôt
    private String cheminStockage; // Le chemin où le fichier est sauvegardé (ex: sur serveur ou cloud)
}
