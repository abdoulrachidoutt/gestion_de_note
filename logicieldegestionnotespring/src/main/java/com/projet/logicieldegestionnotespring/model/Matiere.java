package com.projet.logicieldegestionnotespring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "matiere")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private  double coef;

    @JsonBackReference
    @OneToMany(mappedBy = "matiere")
    Collection<Evaluation> evaluation= new ArrayList<>();
}
