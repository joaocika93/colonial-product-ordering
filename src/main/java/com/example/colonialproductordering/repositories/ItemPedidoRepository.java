package com.example.colonialproductordering.repositories;

import com.example.colonialproductordering.domains.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

    @Query("SELECT itempedido FROM ItemPedido itempedido WHERE itempedido.googleId = ?1")
    List<ItemPedido> findByUsuario(String googleId);

}
