package com.example.colonialproductordering.services;

import com.example.colonialproductordering.domains.ItemPedido;
import com.example.colonialproductordering.domains.Produto;
import com.example.colonialproductordering.repositories.ItemPedidoRepository;
import com.example.colonialproductordering.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemPedidoService {

    @Autowired
    ItemPedidoRepository itemPedidoRepository;

    @Autowired
    ProdutoService produtoService;

    @Autowired
    PedidoService pedidoService;


    public ItemPedido buscar(Integer id) {
        Optional<ItemPedido> obj = itemPedidoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + ItemPedido.class.getName()));
    }

    public String save(ItemPedido itemPedido) {
        Produto produto = produtoService.buscar(itemPedido.getProduto().getId());

        itemPedido.setProduto(produto);

        itemPedidoRepository.save(itemPedido);
        return "Salvo com Sucesso";
    }

}
