package com.projet.logicieldegestionnotespring.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "direction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Direction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;


    @JsonBackReference
    @OneToMany(mappedBy = "direction")
    Collection<Agent> agent= new ArrayList<>();
}
