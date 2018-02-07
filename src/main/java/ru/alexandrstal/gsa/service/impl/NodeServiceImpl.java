package ru.alexandrstal.gsa.service.impl;

import org.springframework.stereotype.Service;
import ru.alexandrstal.gsa.domain.Graph;
import ru.alexandrstal.gsa.domain.Status;
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

    public Node findById(Long id) {
        return entityManager.find(Node.class, id);
    }

    @Override
    public List<Node> findAll() {
        return entityManager.createQuery("select v from Node v", Node.class).getResultList();
    }

}
