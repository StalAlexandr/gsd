package ru.alexandrstal.gsa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.alexandrstal.gsa.domain.Application;
import ru.alexandrstal.gsa.domain.Node;
import ru.alexandrstal.gsa.service.ApplicationService;
import ru.alexandrstal.gsa.service.NetworkService;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value = "api")
public class MainController {

    @Autowired
    NetworkService networkService;

    @Autowired
    ApplicationService applicationService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "network", method = RequestMethod.GET)
    public List<Node> findAll(){
        return networkService.findAll();
    }

    @RequestMapping(value = "application/{id}", method = RequestMethod.GET)
    public Application findApplicationByExtidappli(@PathVariable("id")String extidappli){
        return applicationService.findByExtidappli(extidappli);
    }

}
