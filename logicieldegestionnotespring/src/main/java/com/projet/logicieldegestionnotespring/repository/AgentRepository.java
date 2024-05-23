package com.projet.logicieldegestionnotespring.repository;

import com.projet.logicieldegestionnotespring.model.Agent;
import com.projet.logicieldegestionnotespring.model.Sousstructure;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
}
