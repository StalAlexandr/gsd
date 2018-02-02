package ru.alexandrstal.gsa.service;

import ru.alexandrstal.gsa.domain.Graph;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public interface GraphService {

    void init();

    Graph findById(Long id);


}
