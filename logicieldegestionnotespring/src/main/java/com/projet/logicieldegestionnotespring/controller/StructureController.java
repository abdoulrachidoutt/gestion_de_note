package com.projet.logicieldegestionnotespring.controller;

import com.projet.logicieldegestionnotespring.Services.StructureService;
import com.projet.logicieldegestionnotespring.dao.StructureDto;
import com.projet.logicieldegestionnotespring.model.Structure;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/structure")
public class StructureController {
    @Autowired
     private StructureService structureService;

    @PostMapping("/create")
    void createStructure(@RequestBody StructureDto structureDto ){
        Structure structure = new Structure();
        structure.setNom(structureDto.getNom());


        this.structureService.createStructure(structure);
    }

    @GetMapping("/read")
    List<Structure> findAllStructure(){
        return this.structureService.findStructure();
    }

    @GetMapping("/structure/{id}")
    Structure getOneStructure(@PathVariable Long id){
        return  this.structureService.findOneStructure(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStructure(@PathVariable  Long id) {
        this.structureService.delete(id);
    }
}
