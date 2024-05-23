package com.projet.logicieldegestionnotespring.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "evaluations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Evaluations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int annee;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
    private Date date_eval;
    private int code_agent;
    private String nomagent;
    private double avance;

    private double moy;
    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "evaluations", fetch=FetchType.EAGER)
    private List<Levaluations> levaluations = new ArrayList<>();
}
