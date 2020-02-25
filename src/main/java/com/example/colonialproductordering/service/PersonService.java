package com.example.colonialproductordering.service;

import com.example.colonialproductordering.model.Person;
import com.example.colonialproductordering.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public String save(Person person){
        repository.save(person);
        return "Person Created";
    }

}
