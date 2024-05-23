package com.projet.logicieldegestionnotespring.ServiceImpl;

import com.projet.logicieldegestionnotespring.Services.StructureService;
import com.projet.logicieldegestionnotespring.model.Structure;
import com.projet.logicieldegestionnotespring.repository.StructureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StructureServiceImpl implements StructureService {

    final  private StructureRepository structureRepository;
    public StructureServiceImpl(StructureRepository structureRepository){
         this.structureRepository = structureRepository;
    }
    @Override
    public void createStructure(Structure structure) {
     this.structureRepository.save(structure);
    }

    @Override
    public List<Structure> findStructure() {

        return structureRepository.findAll();
    }

    @Override
    public Structure findOneStructure(long id) {

        return this.structureRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        this.structureRepository.deleteById(id);
    }

}
