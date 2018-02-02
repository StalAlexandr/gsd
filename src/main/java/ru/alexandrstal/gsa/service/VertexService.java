package ru.alexandrstal.gsa.service;

import ru.alexandrstal.gsa.domain.Vertex;

import java.util.List;

public interface VertexService {

    void init();

    Vertex findById(Long id);

    List<Vertex> findAll();
}
