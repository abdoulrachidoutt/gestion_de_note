package com.projet.logicieldegestionnotespring.repository;

import com.projet.logicieldegestionnotespring.model.Matiere;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface MatiereRepository extends JpaRepository<Matiere,Long> {
}
