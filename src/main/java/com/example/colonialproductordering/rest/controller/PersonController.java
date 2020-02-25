package com.example.colonialproductordering.rest.controller;

import com.example.colonialproductordering.model.Person;
import com.example.colonialproductordering.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping("/add")
    public ResponseEntity<Person> save(@RequestBody Person person){
        personService.save(person);
        return ResponseEntity.ok().body(person);
    }



}
