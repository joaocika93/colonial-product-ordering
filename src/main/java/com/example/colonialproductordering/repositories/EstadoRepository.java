package com.example.colonialproductordering.repositories;

import com.example.colonialproductordering.domains.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

    @Query("SELECT estado FROM Estado estado WHERE estado.uf = ?1")
    Estado findByEstado(String uf);

}
