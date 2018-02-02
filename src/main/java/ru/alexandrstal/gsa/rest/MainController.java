package ru.alexandrstal.gsa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.alexandrstal.gsa.domain.Vertex;
import ru.alexandrstal.gsa.service.VertexService;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class MainController {

    @Autowired
    VertexService vertexService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String hello(){
        vertexService.init();
        return "hello";
    }

    @RequestMapping(value = "vertex", method = RequestMethod.GET)
    public List<Vertex> findAll(){
        return vertexService.findAll();
    }

    @RequestMapping(value = "vertex/{id}", method = RequestMethod.GET)
    public Vertex find(@PathVariable("id") Long id){
        return vertexService.findById(id);
    }
}
