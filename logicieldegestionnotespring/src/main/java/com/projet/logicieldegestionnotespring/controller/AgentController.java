package com.projet.logicieldegestionnotespring.controller;

import com.projet.logicieldegestionnotespring.Services.*;
import com.projet.logicieldegestionnotespring.dao.AgentDto;
import com.projet.logicieldegestionnotespring.dao.SousstructureDto;
import com.projet.logicieldegestionnotespring.model.Agent;
import com.projet.logicieldegestionnotespring.model.Direction;
import com.projet.logicieldegestionnotespring.model.Sousstructure;
import com.projet.logicieldegestionnotespring.model.Structure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AgentController {
    @Autowired
    private AgentService agentService;

//    @Autowired
//    SousstructureService sousstructureService;

    @Autowired
    DirectionService directionService;




    @PostMapping("/create")
    void createAgent(@RequestBody AgentDto agentDto){
        Agent agent = new Agent();
        agent.setMatricule(agentDto.getMatricule());
        agent.setNom(agentDto.getNom());
        agent.setPrenom(agentDto.getPrenom());
        agent.setTel(agentDto.getTel());
        agent.setDirection(this.directionService.getOneDirection(agentDto.getDirectionId()));

        this.agentService.createAgent(agent);
    }


//    @PostMapping("/create")
//    public ResponseEntity<Sousstructure> createSousstructure(@RequestBody Sousstructure sousstructureDto){
//        return  new ResponseEntity<>(sousstructureService.save(sousstructureDto), HttpStatus.CREATED);
//    }

    @GetMapping("/read")
    List<Agent> agent(){
        return  this.agentService.getAgent();
    }

    @GetMapping("/direction")
    public ResponseEntity<List<Direction>> listDirection(){
        return  new ResponseEntity<>(directionService.getDirection(), HttpStatus.OK)   ;
    }




    @GetMapping("/agent/{id}")
    Agent getOneAgent(@PathVariable Long id){
        return this.agentService.getOneAgent(id);
    }


//    @PutMapping("/modifier/{id}")
//    public ResponseEntity<SousstructureDto> actualiser(@PathVariable Long id, @RequestBody SousstructureDto sousstructureDto){
//        Sousstructure sousstructureDto1 = sousstructureService.getOneSoustructure(id);
//
//        if(sousstructureDto1 ==null){
//            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//
//        try {
//            sousstructureDto1.setNom(sousstructureDto.getNom());
//            sousstructureDto1.setStructure(this.sousstructureService.getSousstructure(sousstructureDto.getStructureId()));
//            this.sousstructureService.createSousstructure(sousstructureDto1);
//        }catch (DataAccessException e){
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//        return null;
//    }

//    @DeleteMapping("deleteby/{id}")
//    public ResponseEntity<?> actualiser(@PathVariable Long id){
//        sousstructureService.delete(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Agent> ObtenirAgent(@PathVariable Long id){
        return new ResponseEntity<>(agentService.getOneAgent(id),HttpStatus.OK);
    }



    @GetMapping("/agent/paging")
    public ResponseEntity<Map<String, Object>> findAllByPaging(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
        return new ResponseEntity<>(this.agentService.findAllAgent(page, size), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteAgent(@PathVariable  long id) {
        this.agentService.delete(id);
    }

    @PutMapping("update/{id}")
    public  Agent updateAgent(@RequestBody AgentDto e, @PathVariable long id) {
        Agent agent = new Agent();
        agent.setMatricule(e.getMatricule());
        agent.setNom(e.getNom());
        agent.setPrenom(e.getPrenom());
        agent.setTel(e.getTel());
        agent.setDirection(this.directionService.getOneDirection(e.getDirectionId()));

        return this.agentService.update(agent, id);
    }
}
