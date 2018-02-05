package ru.alexandrstal.gsa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alexandrstal.gsa.domain.Vertex;
import ru.alexandrstal.gsa.service.VertexService;

import java.util.List;


@CrossOrigin(allowCredentials = "true")
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

    @CrossOrigin(allowCredentials = "true")
    @RequestMapping(value = "vertex", method = RequestMethod.GET)
    public ResponseEntity<List<Vertex>> findAll(){

        System.out.println("ASDFHGFHGFHGFHGFHGFH");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Headers", "x-requested-with");
        headers.add("Access-Control-Allow-Origin", "*");

        return new ResponseEntity<List<Vertex>>(vertexService.findAll(),headers, HttpStatus.OK);
      //  return vertexService.findAll();
    }

    @CrossOrigin("http://localhost")
    @RequestMapping(value = "vertex/{id}", method = RequestMethod.GET)
    public Vertex find(@PathVariable("id") Long id){
        return vertexService.findById(id);
    }
}
