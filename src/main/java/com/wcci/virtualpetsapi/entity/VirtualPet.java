package com.wcci.virtualpetsapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class VirtualPet {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private int hunger;

    private int thirst; 

    private int boredom;

    public VirtualPet(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
