package ru.alexandrstal.gsa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.alexandrstal.gsa.domain.Node;
import ru.alexandrstal.gsa.service.NodeService;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value = "api")
public class MainController {

    @Autowired
    NodeService nodeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String hello(){
        nodeService.init();
        return "hello";
    }

    @RequestMapping(value = "vertex", method = RequestMethod.GET)
    public List<Node> findAll(){
        return nodeService.findAll();
    }

    @RequestMapping(value = "vertex/{id}", method = RequestMethod.GET)
    public Node find(@PathVariable("id") Long id){
        return nodeService.findById(id);
    }
}
