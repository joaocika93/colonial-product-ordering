package com.example.colonialproductordering.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private Integer idProduct;
    private String name;
    private Float value;
    private String description;
    private String img;
    private Integer favorite;
}
