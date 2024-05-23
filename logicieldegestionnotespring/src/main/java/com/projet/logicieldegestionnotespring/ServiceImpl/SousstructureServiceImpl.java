package com.projet.logicieldegestionnotespring.ServiceImpl;

import com.projet.logicieldegestionnotespring.Services.SousstructureService;
import com.projet.logicieldegestionnotespring.model.Sousstructure;
import com.projet.logicieldegestionnotespring.model.Structure;
import com.projet.logicieldegestionnotespring.repository.SousstructureRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SousstructureServiceImpl implements SousstructureService {


    final private SousstructureRepository sousstructureRepository;
    public SousstructureServiceImpl(SousstructureRepository sousstructureRepository){
        this.sousstructureRepository = sousstructureRepository;
    }

    @Override
    public void createSousstructure(Sousstructure sousstructure) {
           this.sousstructureRepository.save(sousstructure);
    }

    @Override
    public List<Sousstructure> getSousstructure() {
        return this.sousstructureRepository.findAll();
    }

    @Override
    public Sousstructure getOneSoustructure(Long id) {
        return sousstructureRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteby(long id) {
        sousstructureRepository.deleteById(id);
    }



    @Override
    public Sousstructure save(Sousstructure sousstructure) {
        return sousstructureRepository.save(sousstructure);
    }

    @Override
    public Map<String, Object> findAllSousstructure(int page, int size) {
        try {
            List<Sousstructure> sousstructureList =  new ArrayList<>();
            Pageable paging =  PageRequest.of(page, size);
            Page<Sousstructure> pageSousstructure =  this.sousstructureRepository.findAll(paging);
            sousstructureList =  pageSousstructure.getContent();

            Map<String, Object> sousstructures = new HashMap<>();

            sousstructures.put("sousstructures", sousstructureList);
            sousstructures.put("pageCurrent", pageSousstructure.getNumber());
            sousstructures.put("totalItems", pageSousstructure.getTotalElements());
            sousstructures.put("totalPage", pageSousstructure.getTotalPages());

            return  sousstructures;

        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
   this.sousstructureRepository.deleteById(id);
    }

    @Override
    public Sousstructure update(Sousstructure e, long id) {
        Sousstructure sousstructure =  this.getOneSoustructure(id);

        sousstructure.setNom(e.getNom());
        sousstructure.setStructure(e.getStructure());

        return this.sousstructureRepository.save(sousstructure);

    }


}
