package com.projet.logicieldegestionnotespring.Services;

import com.projet.logicieldegestionnotespring.model.Direction;
import com.projet.logicieldegestionnotespring.model.Sousstructure;

import java.util.List;
import java.util.Map;

public interface DirectionService {

    public void createDirection(Direction direction);

    public List<Direction> getDirection();

    public Direction getOneDirection(Long id);

    public void deleteby(long id);



    public Direction save(Direction direction);

    Map<String, Object> findAllDirection(int page, int size);


    void delete(Long id);

    Direction update(Direction e, long id);
}
