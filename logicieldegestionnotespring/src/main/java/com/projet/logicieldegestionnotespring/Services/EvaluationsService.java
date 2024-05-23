package com.projet.logicieldegestionnotespring.Services;

import com.projet.logicieldegestionnotespring.model.Evaluation;
import com.projet.logicieldegestionnotespring.model.Evaluations;

import java.util.List;

public interface EvaluationsService {

    public void createEvaluations(Evaluations evaluations);

    public List<Evaluations> getEvaluations();

    public Evaluations getOneEvaluations(Long id);

}
