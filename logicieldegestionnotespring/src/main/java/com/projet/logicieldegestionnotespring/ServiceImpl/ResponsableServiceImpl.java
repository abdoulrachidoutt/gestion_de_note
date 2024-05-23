package com.projet.logicieldegestionnotespring.ServiceImpl;

import com.projet.logicieldegestionnotespring.Services.ResponsableService;
import com.projet.logicieldegestionnotespring.model.Responsable;
import com.projet.logicieldegestionnotespring.model.Structure;
import com.projet.logicieldegestionnotespring.repository.ResponsableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsableServiceImpl implements ResponsableService {

    private  final ResponsableRepository responsableRepository;
    public ResponsableServiceImpl(ResponsableRepository responsableRepository){
        this.responsableRepository = responsableRepository;
    }

    @Override
    public void createResponsable(Responsable responsable) {
        this.responsableRepository.save(responsable);
    }

    @Override
    public List<Responsable> findResponsable() {
        return responsableRepository.findAll();
    }

    @Override
    public Responsable findOneResponsable(long id) {
          return this.responsableRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        this.responsableRepository.deleteById(id);
    }
}
