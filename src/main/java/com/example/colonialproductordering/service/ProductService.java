package com.example.colonialproductordering.service;

import com.example.colonialproductordering.model.Product;
import com.example.colonialproductordering.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public String save(Product product){
        productRepository.save(product);
        return "Person Created";
    }
}
