package com.projet.logicieldegestionnotespring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "agent")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer matricule;
    @Column(length = 50 )
    private String nom;
    @Column(length = 150)
    private String prenom;
    private Integer tel ;


    @ManyToOne
    Direction direction;


//    @JsonBackReference
//    @OneToMany(mappedBy = "agent")
//    Collection<Evaluation> evaluation= new ArrayList<>();

//    @ManyToOne
//    Sousstructure sousstructure;

//       @JsonBackReference
//       @OneToOne(mappedBy = "agent")
//       private Responsable responsable;


}
