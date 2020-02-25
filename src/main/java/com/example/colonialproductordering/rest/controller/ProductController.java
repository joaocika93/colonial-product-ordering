package com.example.colonialproductordering.rest.controller;

import com.example.colonialproductordering.model.Product;
import com.example.colonialproductordering.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Product> save(@RequestBody Product product){
        productService.save(product);
        return ResponseEntity.ok().body(product);
    }
}
