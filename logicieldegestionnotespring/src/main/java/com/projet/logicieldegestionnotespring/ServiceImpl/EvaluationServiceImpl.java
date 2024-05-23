package com.projet.logicieldegestionnotespring.ServiceImpl;

import com.projet.logicieldegestionnotespring.Services.EvaluationService;
import com.projet.logicieldegestionnotespring.model.Direction;
import com.projet.logicieldegestionnotespring.model.Evaluation;
import com.projet.logicieldegestionnotespring.repository.DirectionRepository;
import com.projet.logicieldegestionnotespring.repository.EvaluationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EvaluationServiceImpl implements EvaluationService {
    final private EvaluationRepository evaluationRepository;
    public EvaluationServiceImpl(EvaluationRepository evaluationRepository){
        this.evaluationRepository = evaluationRepository;
    }

    @Override
    public void createEvaluation(Evaluation evaluation) {
        this.evaluationRepository.save(evaluation);
    }

    @Override
    public List<Evaluation> getEvaluation() {
        return this.evaluationRepository.findAll();
    }

    @Override
    public Evaluation getOneEvaluation(Long id) {
        return evaluationRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteby(long id) {
        evaluationRepository.deleteById(id);
    }



    @Override
    public Evaluation save(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }



    @Override
    public void delete(Long id) {
        this.evaluationRepository.deleteById(id);
    }

    @Override
    public Evaluation update(Evaluation e, long id) {
        Evaluation evaluation =  this.getOneEvaluation(id);




        return this.evaluationRepository.save(evaluation);

    }
}
