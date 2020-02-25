package com.example.colonialproductordering.repository;

import com.example.colonialproductordering.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PersonRepository extends CrudRepository<Person, Long> {
}
