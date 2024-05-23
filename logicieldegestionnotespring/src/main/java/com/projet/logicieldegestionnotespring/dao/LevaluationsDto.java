package com.projet.logicieldegestionnotespring.dao;

import jakarta.persistence.Column;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LevaluationsDto {

    private String id_matiere;
    private String nommatiere;
    private int coef;
    private double note;
    private int moy;


    private Long evaluationsId;
}
