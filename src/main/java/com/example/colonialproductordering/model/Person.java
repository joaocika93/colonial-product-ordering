package com.example.colonialproductordering.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue
    private Integer idPerson;
    private String name;
    private String role;

 }
