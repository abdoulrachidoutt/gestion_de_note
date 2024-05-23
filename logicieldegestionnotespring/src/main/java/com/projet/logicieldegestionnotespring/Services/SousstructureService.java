package com.projet.logicieldegestionnotespring.Services;

import com.projet.logicieldegestionnotespring.model.Sousstructure;
import com.projet.logicieldegestionnotespring.model.Structure;

import java.util.List;
import java.util.Map;

public interface SousstructureService {
   public void createSousstructure(Sousstructure sousstructure);

   public List<Sousstructure> getSousstructure();

   public Sousstructure getOneSoustructure(Long id);

    public void deleteby(long id);



    public Sousstructure save(Sousstructure sousstructure);

    Map<String, Object> findAllSousstructure(int page, int size);


    void delete(Long id);

    Sousstructure update(Sousstructure e, long id);
}
