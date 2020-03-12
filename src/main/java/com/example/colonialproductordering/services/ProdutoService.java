package com.example.colonialproductordering.services;

import com.example.colonialproductordering.domains.Produto;
import com.example.colonialproductordering.repositories.ProdutoRepository;
import com.example.colonialproductordering.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public Produto buscar(Integer id) {
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
    }

    public Page<Produto> findPagination (int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return produtoRepository.findAll(pageable);
    }


    public String save(Produto produto){
        produtoRepository.save(produto);
        return "Salvo com Sucesso";
    }
}
