package com.projet.logicieldegestionnotespring.Services;

import com.projet.logicieldegestionnotespring.model.Direction;
import com.projet.logicieldegestionnotespring.model.Evaluation;

import java.util.List;
import java.util.Map;

public interface EvaluationService {
    public void createEvaluation(Evaluation evaluation);

    public List<Evaluation> getEvaluation();

    public Evaluation getOneEvaluation(Long id);

    public void deleteby(long id);



    public Evaluation save(Evaluation Evaluation);




    void delete(Long id);

    Evaluation update(Evaluation e, long id);
}
