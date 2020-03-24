package com.example.colonialproductordering.repositories;

import com.example.colonialproductordering.domains.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Query(value = "SELECT * FROM cidade WHERE nome = ?1", nativeQuery = true)
    List<Cidade> findByCidade(String cidade);

}
