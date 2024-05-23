package com.projet.logicieldegestionnotespring.dao;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationDto {

    private Integer moy;

    private Long agentId;
    private Long matiereId;



}
