package com.projet.logicieldegestionnotespring.dao;


import jakarta.persistence.Column;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgentDto {

    private Integer matricule;

    private String nom;

    private String prenom;
    private Integer tel ;


    private Long directionId;


}
