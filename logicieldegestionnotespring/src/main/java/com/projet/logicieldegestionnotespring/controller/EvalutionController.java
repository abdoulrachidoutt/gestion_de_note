package com.projet.logicieldegestionnotespring.controller;

import com.projet.logicieldegestionnotespring.Services.AgentService;
import com.projet.logicieldegestionnotespring.Services.DirectionService;
import com.projet.logicieldegestionnotespring.Services.EvaluationService;
import com.projet.logicieldegestionnotespring.Services.MatiereService;
import com.projet.logicieldegestionnotespring.dao.DirectionDto;
import com.projet.logicieldegestionnotespring.dao.EvaluationDto;
import com.projet.logicieldegestionnotespring.model.Agent;
import com.projet.logicieldegestionnotespring.model.Direction;
import com.projet.logicieldegestionnotespring.model.Evaluation;
import com.projet.logicieldegestionnotespring.model.Matiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/evaluation")
public class EvalutionController {
    @Autowired
    EvaluationService evaluationService;

    @Autowired
    MatiereService matiereService;

    @Autowired
    AgentService agentService;

    @PostMapping("/create")
    void createEvaluation(@RequestBody EvaluationDto evaluationDto ){
        Evaluation evaluation = new Evaluation();
        evaluation.setMoy(evaluationDto.getMoy());
        evaluation.setMatiere(this.matiereService.getOneMatiere(evaluationDto.getMatiereId()));
//        evaluation.setAgent(this.agentService.getOneAgent(evaluationDto.getAgentId()));



        this.evaluationService.createEvaluation(evaluation);
    }
    @GetMapping("/agent")
    public ResponseEntity<List<Agent>> listAgent(){
        return  new ResponseEntity<>(agentService.getAgent(), HttpStatus.OK)   ;
    }


    @GetMapping("/matiere")
    public ResponseEntity<List<Matiere>> listMatiere(){
        return  new ResponseEntity<>(matiereService.getMatiere(), HttpStatus.OK)   ;
    }

    @GetMapping("/read")
    List<Evaluation> findAllEvaluation(){
        return this.evaluationService.getEvaluation();
    }

    @GetMapping("/read/{id}")
    Evaluation getOneEvaluation(@PathVariable Long id){
        return  this.evaluationService.getOneEvaluation(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEvaluation(@PathVariable  Long id) {
        this.evaluationService.delete(id);
    }
}
