package com.projet.logicieldegestionnotespring.controller;

import com.projet.logicieldegestionnotespring.Services.SousstructureService;
import com.projet.logicieldegestionnotespring.Services.StructureService;
import com.projet.logicieldegestionnotespring.dao.SousstructureDto;
import com.projet.logicieldegestionnotespring.dao.StructureDto;
import com.projet.logicieldegestionnotespring.model.Sousstructure;
import com.projet.logicieldegestionnotespring.model.Structure;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/sousstructures")
public class SousstructureController {
    @Autowired
    private SousstructureService sousstructureService;

    @Autowired
    StructureService structureService;

    @PostMapping("/create")
    void createSousstructure(@RequestBody SousstructureDto sousstructureDto){
        Sousstructure sousstructure = new Sousstructure();
        sousstructure.setNom(sousstructureDto.getNom());
        sousstructure.setStructure(this.structureService.findOneStructure(sousstructureDto.getStructureId()));
        this.sousstructureService.createSousstructure(sousstructure);
    }


//    @PostMapping("/create")
//    public ResponseEntity<Sousstructure> createSousstructure(@RequestBody Sousstructure sousstructureDto){
//        return  new ResponseEntity<>(sousstructureService.save(sousstructureDto), HttpStatus.CREATED);
//    }

    @GetMapping("/read")
    List<Sousstructure> Sousstructures(){
          return  this.sousstructureService.getSousstructure();
    }

    @GetMapping("/structure")
    public ResponseEntity<List<Structure>> listStructure(){
     return  new ResponseEntity<>(structureService.findStructure(), HttpStatus.OK)   ;
    }


    @GetMapping("/sousstructures/{id}")
    Sousstructure getOneSoustructrure(@PathVariable Long id){
        return this.sousstructureService.getOneSoustructure(id);
    }


    @PutMapping("/modifier/{id}")
    public ResponseEntity<SousstructureDto> actualiser(@PathVariable Long id, @RequestBody SousstructureDto sousstructureDto){
        Sousstructure sousstructureDto1 = sousstructureService.getOneSoustructure(id);

        if(sousstructureDto1 ==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        try {
            sousstructureDto1.setNom(sousstructureDto.getNom());
            sousstructureDto1.setStructure(this.structureService.findOneStructure(sousstructureDto.getStructureId()));
             this.sousstructureService.createSousstructure(sousstructureDto1);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return null;
    }

@DeleteMapping("deleteby/{id}")
    public ResponseEntity<?> actualiser(@PathVariable Long id){
       sousstructureService.delete(id);
       return new ResponseEntity<>(HttpStatus.OK);
}

@GetMapping("/{id}")
    public ResponseEntity<Sousstructure> ObtenirSousstructure(@PathVariable Long id){
        return new ResponseEntity<>(sousstructureService.getOneSoustructure(id),HttpStatus.OK);
}



    @GetMapping("/sousstructure/paging")
    public ResponseEntity<Map<String, Object>> findAllByPaging(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
        return new ResponseEntity<>(this.sousstructureService.findAllSousstructure(page, size), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable  long id) {
        this.sousstructureService.delete(id);
    }

    @PutMapping("update/{id}")
    public  Sousstructure updateEmployee(@RequestBody SousstructureDto e, @PathVariable long id) {
        Sousstructure sousstructure = new Sousstructure();
        sousstructure.setNom(e.getNom());
        sousstructure.setStructure(this.structureService.findOneStructure(e.getStructureId()));

        return this.sousstructureService.update(sousstructure, id);
    }

}
