package ru.alexandrstal.gsa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.alexandrstal.gsa.domain.Graph;
import ru.alexandrstal.gsa.service.GraphService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
@RequestMapping(value = "asd")
public class MainController {

    @Autowired
    GraphService graphService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String hello(){

        graphService.init();
        return "hello";
    }

    @RequestMapping(value = "find/{id}", method = RequestMethod.GET)
    public Graph find(@PathVariable("id") Long id){
        return graphService.findById(id);
    }

}
