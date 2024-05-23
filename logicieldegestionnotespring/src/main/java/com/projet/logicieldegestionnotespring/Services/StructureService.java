package com.projet.logicieldegestionnotespring.Services;

import com.projet.logicieldegestionnotespring.model.Structure;

import java.util.List;

public interface StructureService {

    void createStructure(Structure structure);

    public List<Structure> findStructure();

    Structure findOneStructure(long id);

     void delete(Long id);

}
