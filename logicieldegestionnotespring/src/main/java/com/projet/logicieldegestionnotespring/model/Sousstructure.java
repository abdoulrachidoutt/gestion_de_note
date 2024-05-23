package com.projet.logicieldegestionnotespring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "sousstructure")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sousstructure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToOne
    Structure structure;

//    @JsonBackReference
//    @OneToMany(mappedBy = "sousstructure")
//    Collection<Agent> agent= new ArrayList<>();

}
