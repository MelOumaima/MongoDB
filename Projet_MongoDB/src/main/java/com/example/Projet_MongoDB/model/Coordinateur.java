package com.example.Projet_MongoDB.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;



@EqualsAndHashCode(callSuper = true)
@Document(collection = "coordinateurs")
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Coordinateur extends Encadrant {

    public Coordinateur() {
        this.setRole("Coordinateur");
    }

}
