package com.projet.logicieldegestionnotespring.controller;

import com.projet.logicieldegestionnotespring.Services.DirectionService;
import com.projet.logicieldegestionnotespring.Services.EvaluationsService;
import com.projet.logicieldegestionnotespring.dao.AgentDto;
import com.projet.logicieldegestionnotespring.dao.EvaluationsDto;
import com.projet.logicieldegestionnotespring.model.Agent;
import com.projet.logicieldegestionnotespring.model.Evaluation;
import com.projet.logicieldegestionnotespring.model.Evaluations;
import com.projet.logicieldegestionnotespring.repository.EvaluationsRepository;
import com.projet.logicieldegestionnotespring.repository.LevaluationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/evaluations")
public class EvaluationsController {
    @Autowired
    EvaluationsService evaluationsService;

@Autowired
    EvaluationsRepository evaluationsRepository;

@Autowired
    LevaluationsRepository levaluationsRepository;


    @PostMapping("/create")
    void createEvaluations(@RequestBody EvaluationsDto evaluationsDto){
        Evaluations evaluations = new Evaluations();
        evaluations.setAnnee(evaluationsDto.getAnnee());
        evaluations.setDate_eval(evaluationsDto.getDate_eval());
        evaluations.setCode_agent(evaluationsDto.getCode_agent());
        evaluations.setNomagent(evaluationsDto.getNomagent());
        evaluations.setAvance(evaluationsDto.getAvance());

        evaluations.setMoy(evaluationsDto.getMoy());

        this.evaluationsService.createEvaluations(evaluations);
    }

    @GetMapping("/read")
    List<Evaluations> findAllEvaluations(){
        return this.evaluationsService.getEvaluations();
    }

    @GetMapping("/read/{id}")
    Evaluations getOneEvaluations(@PathVariable Long id){
        return  this.evaluationsService.getOneEvaluations(id);
    }


    @DeleteMapping("/evaluations/{id}")
    public ResponseEntity<Evaluations> deleteComm(@PathVariable(value = "id") Long EvaluationsId)
    {
        Optional<Evaluations> EvaluationsInfo = evaluationsRepository.findById(EvaluationsId);
        if (EvaluationsInfo.isPresent()) {
            System.out.println("Commande 11");
            Evaluations Evaluations = EvaluationsInfo.get();
            levaluationsRepository.deleteById(Evaluations.getId());
            evaluationsRepository.delete(Evaluations);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/evaluations/delete")
    public ResponseEntity<String> deleteAllComms() {
        System.out.println("Delete All Comms...");
        evaluationsRepository.deleteAll();
        return new ResponseEntity<>("All Comms have been deleted!", HttpStatus.OK);
    }

    @PutMapping("/evaluations/{id}")
    public ResponseEntity<Evaluations> updateComm(@PathVariable("id") long id, @RequestBody Evaluations Comm) {
        System.out.println("Update Comm with ID = " + id + "...");
        Optional<Evaluations> EvaluationsInfo = evaluationsRepository.findById(id);
        if (EvaluationsInfo.isPresent()) {
            Evaluations Evaluations = EvaluationsInfo.get();
            Evaluations.setNomagent(Comm.getNomagent());
            return new ResponseEntity<>(evaluationsRepository.save(Evaluations), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
