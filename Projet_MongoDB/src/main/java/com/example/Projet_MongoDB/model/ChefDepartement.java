package com.example.Projet_MongoDB.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@EqualsAndHashCode(callSuper = true)
@Document(collection = "chefs_departement")
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class ChefDepartement extends Utilisateur {

    public ChefDepartement() {
        this.setRole("ChefDepartement");
    }

}
