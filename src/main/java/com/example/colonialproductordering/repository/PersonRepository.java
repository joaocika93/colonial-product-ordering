package com.example.colonialproductordering.repository;

import com.example.colonialproductordering.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll();


}
