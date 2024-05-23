package com.projet.logicieldegestionnotespring.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationsDto {
    private int annee;
    private Date date_eval;
    private int code_agent;
    private String nomagent;
    private double avance;

    private double moy;
}
