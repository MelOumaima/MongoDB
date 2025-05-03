package com.example.Projet_MongoDB.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;


@Document(collection = "attestations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attestation {

    @Id
    private String id;

    private boolean estSignee;         // L'attestation est-elle signée ?
    private Date dateValidation;        // Date de signature/validation

    @DBRef
    private Coordinateur signePar;      // Coordinateur qui a validé et signé
}
