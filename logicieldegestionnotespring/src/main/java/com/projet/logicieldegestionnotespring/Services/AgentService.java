package com.projet.logicieldegestionnotespring.Services;

import com.projet.logicieldegestionnotespring.model.Agent;
import com.projet.logicieldegestionnotespring.model.Sousstructure;

import java.util.List;
import java.util.Map;

public interface AgentService {

    public void createAgent(Agent agent);

    public List<Agent> getAgent();

    public Agent getOneAgent(Long id);



    public Agent save(Agent agent);

    Map<String, Object> findAllAgent(int page, int size);


    void delete(Long id);

    Agent update(Agent e, long id);
}
