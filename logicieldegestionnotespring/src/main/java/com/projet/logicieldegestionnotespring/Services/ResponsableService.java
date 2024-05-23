package com.projet.logicieldegestionnotespring.Services;

import com.projet.logicieldegestionnotespring.model.Responsable;
import com.projet.logicieldegestionnotespring.model.Structure;

import java.util.List;

public interface ResponsableService {

    void createResponsable(Responsable responsable);

    public List<Responsable> findResponsable();

    Responsable findOneResponsable(long id);

    void delete(Long id);
}
