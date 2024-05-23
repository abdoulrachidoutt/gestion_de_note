package com.projet.logicieldegestionnotespring.ServiceImpl;

import com.projet.logicieldegestionnotespring.Services.EvaluationsService;
import com.projet.logicieldegestionnotespring.model.Evaluation;
import com.projet.logicieldegestionnotespring.model.Evaluations;
import com.projet.logicieldegestionnotespring.repository.EvaluationRepository;
import com.projet.logicieldegestionnotespring.repository.EvaluationsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationsServiceImpl implements EvaluationsService {

    final private EvaluationsRepository evaluationsRepository;
    public EvaluationsServiceImpl(EvaluationsRepository evaluationsRepository){
        this.evaluationsRepository = evaluationsRepository;
    }

    @Override
    public void createEvaluations(Evaluations evaluations) {
        this.evaluationsRepository.save(evaluations);
    }

    @Override
    public List<Evaluations> getEvaluations() {
        return this.evaluationsRepository.findAll();
    }

    @Override
    public Evaluations getOneEvaluations(Long id) {
        return evaluationsRepository.findById(id).orElse(null);
    }

}
