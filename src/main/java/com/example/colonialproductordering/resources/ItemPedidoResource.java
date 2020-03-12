package com.example.colonialproductordering.resources;

import com.example.colonialproductordering.domains.ItemPedido;
import com.example.colonialproductordering.repositories.ItemPedidoRepository;
import com.example.colonialproductordering.services.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itempedido")
public class ItemPedidoResource {

    @Autowired
    ItemPedidoRepository itemPedidoRepository;

    @Autowired
    ItemPedidoService itemPedidoService;

    @GetMapping("/get")
    public List<ItemPedido> findAll(){
        return itemPedidoRepository.findAll();
    }

    @PostMapping("/add")
    public String save(@RequestBody ItemPedido itemPedido){
        System.out.println(itemPedido);
        return itemPedidoService.save(itemPedido);
    }
}
