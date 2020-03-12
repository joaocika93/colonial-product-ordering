package com.example.colonialproductordering.repositories;

import com.example.colonialproductordering.domains.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer> {

    void deleteById(Long id);

    Page<Produto> findAll(Pageable pageable);

    List<Produto> findAll();

    @Query("SELECT produto FROM Produto produto WHERE produto.nome LIKE %?1%")
    List<Produto> findByNameContainingIgnoreCase (String name);

}
