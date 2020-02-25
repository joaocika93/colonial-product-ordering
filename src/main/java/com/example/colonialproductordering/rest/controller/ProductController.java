package com.example.colonialproductordering.rest.controller;

import com.example.colonialproductordering.model.Product;
import com.example.colonialproductordering.repository.ProductRepository;
import com.example.colonialproductordering.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/all-product")
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    @GetMapping("search/{name}")
    public Product search(@PathVariable("name") String name){
        return productService.search(name);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> save(@RequestBody Product product){
        productService.save(product);
        return ResponseEntity.ok().body(product);
    }
}
