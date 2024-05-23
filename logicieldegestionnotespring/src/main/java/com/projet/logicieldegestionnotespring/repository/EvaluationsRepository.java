package com.projet.logicieldegestionnotespring.repository;

import com.projet.logicieldegestionnotespring.model.Evaluations;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface EvaluationsRepository extends JpaRepository<Evaluations,Long> {
}
