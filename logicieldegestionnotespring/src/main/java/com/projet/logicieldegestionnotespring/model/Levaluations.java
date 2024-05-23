package com.projet.logicieldegestionnotespring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "levaluations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Levaluations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String id_matiere;
    private String nommatiere;
    private int coef;
    private double note;
    private int moy;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private Evaluations evaluations;
}
