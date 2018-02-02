package ru.alexandrstal.gsa.service.impl;

import org.springframework.stereotype.Service;
import ru.alexandrstal.gsa.domain.Graph;
import ru.alexandrstal.gsa.domain.GraphPosition;
import ru.alexandrstal.gsa.domain.GraphRelation;
import ru.alexandrstal.gsa.service.GraphService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class GraphServiceImpl implements GraphService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void init() {

        GraphPosition graphPosition = new GraphPosition();
        graphPosition.setHeight(100);
        graphPosition.setWidth(200);
        graphPosition.setXposition(1);
        graphPosition.setYposition(2);

        Graph graph1 = new Graph();
        graph1.setPosition(graphPosition);

        GraphRelation graphRelation = new GraphRelation();
        graphRelation.setFrom(graph1);
        graphRelation.setTo(graph1);
        graph1.getFrom().add(graphRelation);
        graph1.getTo().add(graphRelation);

        entityManager.persist(graphRelation);
        entityManager.persist(graph1);

    }

    public Graph findById(Long id){
        return entityManager.find(Graph.class, id);
    };

}
