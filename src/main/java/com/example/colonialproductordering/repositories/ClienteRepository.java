package com.example.colonialproductordering.repositories;

import com.example.colonialproductordering.domains.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT cliente FROM Cliente cliente WHERE cliente.googleId = ?1")
    Cliente findByUsuario(String googleId);

}
