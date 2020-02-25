package com.example.colonialproductordering.repository;

import com.example.colonialproductordering.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
}
