package ru.alexandrstal.gsa.service;

import ru.alexandrstal.gsa.domain.Node;

import java.util.List;

public interface NodeService {

    Node findById(Long id);

    List<Node> findAll();
}
