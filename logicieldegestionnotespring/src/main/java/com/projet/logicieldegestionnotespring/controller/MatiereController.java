package com.projet.logicieldegestionnotespring.controller;

import com.projet.logicieldegestionnotespring.Services.AgentService;
import com.projet.logicieldegestionnotespring.Services.MatiereService;
import com.projet.logicieldegestionnotespring.dao.MatiereDto;
import com.projet.logicieldegestionnotespring.model.Direction;
import com.projet.logicieldegestionnotespring.model.Matiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/matiere")
public class MatiereController {

    @Autowired
    MatiereService matiereService;

    @Autowired
    AgentService agentService;


    @PostMapping("/create")
    void createMatiere(@RequestBody MatiereDto matiereDto ){
        Matiere matiere = new Matiere();
        matiere.setNom(matiereDto.getNom());
        matiere.setCoef(matiereDto.getCoef());


        this.matiereService.createMatiere(matiere);
    }


    @GetMapping("/read")
    List<Matiere> findAllMatiere(){
        return this.matiereService.getMatiere();
    }

    @GetMapping("/read/{id}")
    Matiere getOneMatiere(@PathVariable Long id){
        return  this.matiereService.getOneMatiere(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMatiere(@PathVariable  Long id) {
        this.matiereService.delete(id);
    }
}
