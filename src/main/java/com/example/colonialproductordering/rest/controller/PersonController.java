package com.example.colonialproductordering.rest.controller;

import com.example.colonialproductordering.model.Person;
import com.example.colonialproductordering.repository.PersonRepository;
import com.example.colonialproductordering.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/all-person")
    public List<Person> findAll(){
        return personRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Person> save(@RequestBody Person person){
        personService.save(person);
        return ResponseEntity.ok().body(person);
    }



}
