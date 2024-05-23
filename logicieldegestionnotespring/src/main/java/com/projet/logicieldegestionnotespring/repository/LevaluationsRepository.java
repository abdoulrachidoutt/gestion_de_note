package com.projet.logicieldegestionnotespring.repository;

import com.projet.logicieldegestionnotespring.model.Levaluations;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface LevaluationsRepository extends JpaRepository<Levaluations,Long> {
}
