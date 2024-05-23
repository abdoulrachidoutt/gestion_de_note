package com.projet.logicieldegestionnotespring.dao;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponsableDto {

    private String motdepasse;

    private long agentId;
}
