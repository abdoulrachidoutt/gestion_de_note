package com.projet.logicieldegestionnotespring.repository;

import com.projet.logicieldegestionnotespring.model.Structure;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface StructureRepository extends JpaRepository <Structure ,Long> {
}
