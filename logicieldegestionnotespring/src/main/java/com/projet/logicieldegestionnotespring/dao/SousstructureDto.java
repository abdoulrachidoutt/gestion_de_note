package com.projet.logicieldegestionnotespring.dao;

import jakarta.persistence.Entity;
import lombok.*;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SousstructureDto {

    private String nom;

    private long structureId;
}
