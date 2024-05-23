package com.projet.logicieldegestionnotespring.controller;

import com.projet.logicieldegestionnotespring.Services.DirectionService;
import com.projet.logicieldegestionnotespring.dao.DirectionDto;
import com.projet.logicieldegestionnotespring.dao.StructureDto;
import com.projet.logicieldegestionnotespring.model.Direction;
import com.projet.logicieldegestionnotespring.model.Structure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/direction")
public class DirectionController {

    @Autowired
    DirectionService directionService;

    @PostMapping("/create")
    void createDirection(@RequestBody DirectionDto directionDto ){
        Direction direction = new Direction();
        direction.setNom(directionDto.getNom());


        this.directionService.createDirection(direction);
    }

    @GetMapping("/read")
    List<Direction> findAllDirection(){
        return this.directionService.getDirection();
    }

    @GetMapping("/read/{id}")
    Direction getOneDirection(@PathVariable Long id){
        return  this.directionService.getOneDirection(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDirection(@PathVariable  Long id) {
        this.directionService.delete(id);
    }
}
