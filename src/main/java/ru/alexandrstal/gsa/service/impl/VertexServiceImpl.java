package ru.alexandrstal.gsa.service.impl;

import org.springframework.stereotype.Service;
import ru.alexandrstal.gsa.domain.Graph;
import ru.alexandrstal.gsa.domain.Position;
import ru.alexandrstal.gsa.domain.Vertex;
import ru.alexandrstal.gsa.service.VertexService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class VertexServiceImpl implements VertexService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void init() {

        Position position = new Position();
        position.setHeight(100);
        position.setWidth(200);
        position.setXposition(1);
        position.setYposition(2);

        Position position2 = new Position();
        position2.setHeight(300);
        position2.setWidth(400);
        position2.setXposition(5);
        position2.setYposition(7);

        Vertex vertex1 = new Vertex();
        vertex1.setPosition(position);

        Vertex vertex2 = new Vertex();
        vertex2.setPosition(position2);

        Graph graph = new Graph();
        graph.setFrom(vertex1);
        graph.setTo(vertex2);

        entityManager.persist(graph);

    }

    public Vertex findById(Long id) {
        return entityManager.find(Vertex.class, id);
    }

    @Override
    public List<Vertex> findAll() {
        return entityManager.createQuery("select v from Vertex v", Vertex.class).getResultList();
    }

    ;

}
