package com.projet.logicieldegestionnotespring.ServiceImpl;

import com.projet.logicieldegestionnotespring.Services.LevaluationsServices;
import com.projet.logicieldegestionnotespring.model.Evaluations;
import com.projet.logicieldegestionnotespring.model.Levaluations;
import com.projet.logicieldegestionnotespring.repository.EvaluationsRepository;
import com.projet.logicieldegestionnotespring.repository.LevaluationsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevaluationsServiceImpl implements LevaluationsServices {

    final private LevaluationsRepository levaluationsRepository;
    public LevaluationsServiceImpl(LevaluationsRepository levaluationsRepository){
        this.levaluationsRepository = levaluationsRepository;
    }

    @Override
    public void createLevaluations(Levaluations levaluations) {
        this.levaluationsRepository.save(levaluations);
    }

    @Override
    public List<Levaluations> getLevaluations() {
        return this.levaluationsRepository.findAll();
    }

    @Override
    public Levaluations getOneLevaluations(Long id) {
        return levaluationsRepository.findById(id).orElse(null);
    }

}
