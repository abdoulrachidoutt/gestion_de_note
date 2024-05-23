package com.projet.logicieldegestionnotespring.Services;

import com.projet.logicieldegestionnotespring.model.Evaluation;
import com.projet.logicieldegestionnotespring.model.Levaluations;

import java.util.List;

public interface LevaluationsServices {
    public void createLevaluations(Levaluations levaluations);

    public List<Levaluations> getLevaluations();

    public Levaluations getOneLevaluations(Long id);

}
