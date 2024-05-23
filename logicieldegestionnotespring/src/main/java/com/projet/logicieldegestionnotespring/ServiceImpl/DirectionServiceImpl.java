package com.projet.logicieldegestionnotespring.ServiceImpl;

import com.projet.logicieldegestionnotespring.Services.DirectionService;
import com.projet.logicieldegestionnotespring.model.Direction;
import com.projet.logicieldegestionnotespring.model.Sousstructure;
import com.projet.logicieldegestionnotespring.repository.DirectionRepository;
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
public class DirectionServiceImpl implements DirectionService {

    final private DirectionRepository directionRepository;
    public DirectionServiceImpl(DirectionRepository directionRepository){
        this.directionRepository = directionRepository;
    }

    @Override
    public void createDirection(Direction direction) {
        this.directionRepository.save(direction);
    }

    @Override
    public List<Direction> getDirection() {
        return this.directionRepository.findAll();
    }

    @Override
    public Direction getOneDirection(Long id) {
        return directionRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteby(long id) {
        directionRepository.deleteById(id);
    }



    @Override
    public Direction save(Direction direction) {
        return directionRepository.save(direction);
    }

    @Override
    public Map<String, Object> findAllDirection(int page, int size) {
        try {
            List<Direction> directionList =  new ArrayList<>();
            Pageable paging =  PageRequest.of(page, size);
            Page<Direction> pageDirection =  this.directionRepository.findAll(paging);
            directionList =  pageDirection.getContent();

            Map<String, Object> direction = new HashMap<>();

            direction.put("sousstructures", directionList);
            direction.put("pageCurrent", pageDirection.getNumber());
            direction.put("totalItems", pageDirection.getTotalElements());
            direction.put("totalPage", pageDirection.getTotalPages());

            return  direction;

        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        this.directionRepository.deleteById(id);
    }

    @Override
    public Direction update(Direction e, long id) {
        Direction direction =  this.getOneDirection(id);

        direction.setNom(e.getNom());


        return this.directionRepository.save(direction);

    }
}
