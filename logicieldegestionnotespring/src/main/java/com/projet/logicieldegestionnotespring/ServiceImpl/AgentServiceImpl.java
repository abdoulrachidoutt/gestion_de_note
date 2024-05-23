package com.projet.logicieldegestionnotespring.ServiceImpl;

import com.projet.logicieldegestionnotespring.Services.AgentService;
import com.projet.logicieldegestionnotespring.model.Agent;
import com.projet.logicieldegestionnotespring.model.Sousstructure;
import com.projet.logicieldegestionnotespring.repository.AgentRepository;
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
public class AgentServiceImpl implements AgentService {
    final private AgentRepository agentRepository;
    public AgentServiceImpl(AgentRepository agentRepository){
        this.agentRepository = agentRepository;
    }
    @Override
    public void createAgent(Agent agent) {
        this.agentRepository.save(agent);
    }

    @Override
    public List<Agent> getAgent() {
        return this.agentRepository.findAll();
    }

    @Override
    public Agent getOneAgent(Long id) {
        return agentRepository.findById(id).orElse(null);    }

    @Override
    public Agent save(Agent agent) {
        return agentRepository.save(agent);     }

    @Override
    public Map<String, Object> findAllAgent(int page, int size) {
        try {
            List<Agent> AgentList =  new ArrayList<>();
            Pageable paging =  PageRequest.of(page, size);
            Page<Agent> pageAgent =  this.agentRepository.findAll(paging);
            AgentList =  pageAgent.getContent();

            Map<String, Object> agents = new HashMap<>();

            agents.put("sousstructures", AgentList);
            agents.put("pageCurrent", pageAgent.getNumber());
            agents.put("totalItems", pageAgent.getTotalElements());
            agents.put("totalPage", pageAgent.getTotalPages());

            return  agents;

        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
            }

    @Override
    public void delete(Long id) {
        this.agentRepository.deleteById(id);
    }

    @Override
    public Agent update(Agent e, long id) {
        Agent agent =  this.getOneAgent(id);
        agent.setMatricule(e.getMatricule());
        agent.setNom(e.getNom());
        agent.setPrenom(e.getPrenom());
        agent.setTel(e.getTel());
        agent.setDirection(e.getDirection());

        return this.agentRepository.save(agent);

    }
}
