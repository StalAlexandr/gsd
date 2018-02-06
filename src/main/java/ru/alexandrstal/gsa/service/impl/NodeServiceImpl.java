package ru.alexandrstal.gsa.service.impl;

import org.springframework.stereotype.Service;
import ru.alexandrstal.gsa.domain.Graph;
import ru.alexandrstal.gsa.domain.Operation;
import ru.alexandrstal.gsa.domain.Position;
import ru.alexandrstal.gsa.domain.Node;
import ru.alexandrstal.gsa.service.NodeService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class NodeServiceImpl implements NodeService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void init() {

        System.out.print("AAAAAAAA");

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

        Node node1 = new Node();
        node1.setPosition(position);


        Operation operation1 = new Operation("1", "Заявка подана");

        Operation operation2 = new Operation("1", "Патент выдан");


        Node node2 = new Node();
        node2.setPosition(position2);


        Graph graph = new Graph();
        graph.setFrom(node1);
        graph.setTo(node2);

        operation1.setNode(node1);
        operation2.setNode(node2);


        entityManager.persist(graph);

    }

    public Node findById(Long id) {
        return entityManager.find(Node.class, id);
    }

    @Override
    public List<Node> findAll() {
        return entityManager.createQuery("select v from Node v", Node.class).getResultList();
    }

    ;

}
