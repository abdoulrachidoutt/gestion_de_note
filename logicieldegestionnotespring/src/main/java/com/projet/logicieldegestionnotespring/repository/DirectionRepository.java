package com.projet.logicieldegestionnotespring.repository;

import com.projet.logicieldegestionnotespring.model.Direction;
import com.projet.logicieldegestionnotespring.model.Sousstructure;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface DirectionRepository extends JpaRepository<Direction, Long> {
}
