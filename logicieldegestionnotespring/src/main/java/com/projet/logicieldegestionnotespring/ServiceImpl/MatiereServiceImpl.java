package com.projet.logicieldegestionnotespring.ServiceImpl;

import com.projet.logicieldegestionnotespring.Services.MatiereService;
import com.projet.logicieldegestionnotespring.model.Direction;
import com.projet.logicieldegestionnotespring.model.Matiere;
import com.projet.logicieldegestionnotespring.repository.DirectionRepository;
import com.projet.logicieldegestionnotespring.repository.MatiereRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereServiceImpl implements MatiereService {


    final private MatiereRepository matiereRepository;
    public MatiereServiceImpl(MatiereRepository matiereRepository){
        this.matiereRepository= matiereRepository;
    }


    @Override
    public void createMatiere(Matiere matiere) {
       this.matiereRepository.save(matiere);
    }



    @Override
    public List<Matiere> getMatiere() {
        return this.matiereRepository.findAll();
    }

    @Override
    public Matiere getOneMatiere(Long id) {
        return matiereRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
          this.matiereRepository.deleteById(id);
    }


    @Override
    public Matiere update(Matiere e, long id) {
        return null;
    }
}
