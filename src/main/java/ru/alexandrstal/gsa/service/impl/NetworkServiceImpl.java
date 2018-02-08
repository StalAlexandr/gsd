package ru.alexandrstal.gsa.service.impl;

import org.springframework.stereotype.Service;
import ru.alexandrstal.gsa.domain.Node;
import ru.alexandrstal.gsa.service.NetworkService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class NetworkServiceImpl implements NetworkService {

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
