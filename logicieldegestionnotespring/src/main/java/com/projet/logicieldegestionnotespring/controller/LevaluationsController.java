package com.projet.logicieldegestionnotespring.controller;

import com.projet.logicieldegestionnotespring.Services.AgentService;
import com.projet.logicieldegestionnotespring.Services.DirectionService;
import com.projet.logicieldegestionnotespring.Services.EvaluationsService;
import com.projet.logicieldegestionnotespring.Services.LevaluationsServices;
import com.projet.logicieldegestionnotespring.dao.AgentDto;
import com.projet.logicieldegestionnotespring.dao.LevaluationsDto;
import com.projet.logicieldegestionnotespring.exception.ResourceNotFoundException;
import com.projet.logicieldegestionnotespring.model.Agent;
import com.projet.logicieldegestionnotespring.model.Evaluation;
import com.projet.logicieldegestionnotespring.model.Levaluations;
import com.projet.logicieldegestionnotespring.repository.EvaluationsRepository;
import com.projet.logicieldegestionnotespring.repository.LevaluationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/levaluations")
public class LevaluationsController {
    @Autowired
    private LevaluationsServices levaluationsServices;

//    @Autowired
//    SousstructureService sousstructureService;

    @Autowired
    EvaluationsService evaluationsService;

    @Autowired
    LevaluationsRepository levaluationsRepository;




    @PostMapping("/create")
    void createLevaluations(@RequestBody LevaluationsDto levaluationsDto){
        Levaluations levaluations = new Levaluations();
        levaluations.setId_matiere(levaluationsDto.getId_matiere());
        levaluations.setNommatiere(levaluationsDto.getNommatiere());
        levaluations.setCoef(levaluationsDto.getCoef());
        levaluations.setNote(levaluationsDto.getNote());
        levaluations.setMoy(levaluationsDto.getMoy());

        levaluations.setEvaluations(this.evaluationsService.getOneEvaluations(levaluationsDto.getEvaluationsId()));

        this.levaluationsServices.createLevaluations(levaluations);
    }


    @GetMapping("/read")
    List<Levaluations> findAllLevaluation(){
        return this.levaluationsServices.getLevaluations();
    }

    @GetMapping("/read/{id}")
    Levaluations getOneLevaluations(@PathVariable Long id){
        return  this.levaluationsServices.getOneLevaluations(id);
    }



    @DeleteMapping("/levaluations/{id}")
    public Map<String, Boolean> deleteLcomm(@PathVariable(value = "id") Long LevaluationsId)
            throws ResourceNotFoundException {
        Levaluations Levaluations = levaluationsRepository.findById(LevaluationsId)
                .orElseThrow(() -> new ResourceNotFoundException("Lcomm not found  id :: " + LevaluationsId));

        levaluationsRepository.delete(Levaluations);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }






    @PutMapping("/levaluations/{id}")
    public ResponseEntity<Levaluations> updateLevaluations(@PathVariable("id") long id, @RequestBody Levaluations levaluations) {
        System.out.println("Update Lcomm with ID = " + id + "...");

        Optional<Levaluations> LevaluationsInfo = levaluationsRepository.findById(id);

        if (LevaluationsInfo.isPresent()) {
            Levaluations Levaluations = LevaluationsInfo.get();
            levaluations.setEvaluations(levaluations.getEvaluations());



            return new ResponseEntity<>(levaluationsRepository.save(levaluations), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
