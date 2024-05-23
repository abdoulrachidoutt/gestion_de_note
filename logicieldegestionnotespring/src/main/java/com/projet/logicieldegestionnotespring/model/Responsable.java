package com.projet.logicieldegestionnotespring.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "responsable")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Responsable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String motdepasse;

//    @OneToOne()
//    @JoinColumn(name= "fk_agent_id")
//    Agent agent;
    
}
