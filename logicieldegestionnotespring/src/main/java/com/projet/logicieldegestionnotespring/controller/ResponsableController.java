package com.projet.logicieldegestionnotespring.controller;

import com.projet.logicieldegestionnotespring.Services.AgentService;
import com.projet.logicieldegestionnotespring.Services.ResponsableService;
import com.projet.logicieldegestionnotespring.Services.StructureService;
import com.projet.logicieldegestionnotespring.dao.ResponsableDto;
import com.projet.logicieldegestionnotespring.dao.SousstructureDto;
import com.projet.logicieldegestionnotespring.dao.StructureDto;
import com.projet.logicieldegestionnotespring.model.Agent;
import com.projet.logicieldegestionnotespring.model.Responsable;
import com.projet.logicieldegestionnotespring.model.Sousstructure;
import com.projet.logicieldegestionnotespring.model.Structure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/responsable")
public class ResponsableController {

    @Autowired
    private ResponsableService responsableService;

    @Autowired
    AgentService agentService;

    @PostMapping("/create")
    void createResponsable(@RequestBody ResponsableDto responsableDto){
        Responsable responsable = new Responsable();
        responsable.setMotdepasse(responsableDto.getMotdepasse());
//        responsable.setAgent(this.agentService.getOneAgent(responsableDto.getAgentId()));
        this.responsableService.createResponsable(responsable);
    }

    @GetMapping("/read")
    List<Responsable> responsable(){
        return  this.responsableService.findResponsable();
    }

//    @GetMapping("/responsable/{id}")
//    Structure getOneResponsable(@PathVariable Long id){
//        return  this.responsableService.findOneResponsable(id);
//    }

    @DeleteMapping("/delete/{id}")
    public void deleteResponsable(@PathVariable  Long id) {
        this.responsableService.delete(id);
    }
}
