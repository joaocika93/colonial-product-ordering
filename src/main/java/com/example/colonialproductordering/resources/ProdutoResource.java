package com.example.colonialproductordering.resources;

import com.example.colonialproductordering.domains.Pedido;
import com.example.colonialproductordering.domains.Produto;
import com.example.colonialproductordering.repositories.ProdutoRepository;
import com.example.colonialproductordering.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

    @Autowired
    ProdutoService produtoService;

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/getAll")
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {

        Produto obj = produtoService.buscar(id);

        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/get")
    public Page<Produto> findPagination(@RequestParam("page") int page, @RequestParam("size") int size) {
        return produtoService.findPagination(page, size);
    }

    @PostMapping("/add")
    public String save(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }
}
