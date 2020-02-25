package com.example.colonialproductordering.service;

import com.example.colonialproductordering.model.Person;
import com.example.colonialproductordering.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public String save(Person person){
        personRepository.save(person);
        return "Person Created";
    }

}
