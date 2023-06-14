package edu.wat.tim.lab1.controller;

import edu.wat.tim.lab1.model.ChildEntity;
import edu.wat.tim.lab1.model.ParentEntity;
import edu.wat.tim.lab1.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class SampleRestController {

    private final SampleService service;

    @GetMapping("/echo")
    public String echo(String value) {
        return value;
    }

    @GetMapping("/echo/{value}")
    public String echoPath(@PathVariable String value) {
        return value;
    }

    @PostMapping("/entity")
    public ResponseEntity<ParentEntity> createParentEntity(@RequestBody ParentEntity entity) {
        ParentEntity savedEntity = service.createParentEntity(entity);
        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }

    @GetMapping("/entity")
    public ResponseEntity<List<ParentEntity>> getAllEntities() {
        List<ParentEntity> entities = service.getAllEntities();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @PostMapping("/entity/{id}/child")
    public ResponseEntity<ChildEntity> addChildEntity(@RequestBody ChildEntity entity, @PathVariable(value = "id") Long id) {
        ChildEntity savedEntity = service.addChildEntity(entity, id);
        return new ResponseEntity<>(savedEntity, HttpStatus.OK);
    }

    @DeleteMapping("/entity/child/{id}")
    public ResponseEntity<HttpStatus> deleteChildEntity(@PathVariable(value = "id") Long id) {
        service.deleteChildEntity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/entity/{id}")
    public ResponseEntity<ParentEntity> updateEntity(@RequestBody ParentEntity entity, @PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(service.updateEntity(entity, id), HttpStatus.OK);
    }
}
