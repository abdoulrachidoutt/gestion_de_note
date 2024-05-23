package com.projet.logicieldegestionnotespring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "structure")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Structure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;

    @JsonBackReference
     @OneToMany(mappedBy = "structure")
    Collection<Sousstructure> sousstructure= new ArrayList<>();
}
