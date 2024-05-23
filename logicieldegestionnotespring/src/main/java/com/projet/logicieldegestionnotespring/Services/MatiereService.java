package com.projet.logicieldegestionnotespring.Services;

import com.projet.logicieldegestionnotespring.model.Direction;
import com.projet.logicieldegestionnotespring.model.Matiere;

import java.util.List;

public interface MatiereService {

    public void createMatiere(Matiere matiere);

    public List<Matiere> getMatiere();

    public Matiere getOneMatiere(Long id);

    void delete(Long id);

    Matiere update(Matiere e, long id);
}
